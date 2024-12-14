package compute.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import compute.ComputationResult;
import compute.Coordinator;
import compute.ICore;
import data.CsvInputConfig;
import data.DataRequestResponse;
import data.EchoOutputConfig;
import data.FileInputConfig;
import data.FileOutputConfig;
import data.IDataStorage;
import user.IJobSpec;
import user.IJobSpec.InputType;
import user.IJobSpec.OutputType;
import utils.Status;

public class CoordinatorMultiThreaded extends Coordinator {

	private IDataStorage dss;

	Iterator<Integer> ints;

	/**
	 * Instantiate a new CoordinatorImpl with the specified compute core, and
	 * default delimiters of ',' and ';'
	 * 
	 * @param mockICompute The computation core to use
	 */
	public CoordinatorMultiThreaded(ICore mockICompute, IDataStorage dss) {
		computation = mockICompute;
		pair = ",";
		end = ";";
		this.dss = dss;
	}

	/**
	 * Handles a single computation in a multithreaded context
	 * 
	 * @param num    the number to compute on
	 * @param result a list of results in the calling context that the operation's
	 *               output gets added to.
	 * @param prev   the countdown latch of the previous thread, if it exists
	 * @param next   the countdown latch of the next thread in line, if it exists
	 * @return
	 */
	private Callable<Void> computeTask(int num, List<String> result, CountDownLatch prev, CountDownLatch next) {
		return () -> {
			String s = num + pair + computation.compute(num) + end;
			next.await();
			result.add(s);
			prev.countDown();
			return null;
		};
	}

	@Override
	public ComputationResult compute(IJobSpec j) {
		ArrayList<String> results = new ArrayList<>();
		ExecutorService threadPool = Executors.newCachedThreadPool();
		List<Future<?>> exceptionChecker = new ArrayList<>();
		CountDownLatch prev = new CountDownLatch(1);
		CountDownLatch next = new CountDownLatch(1);
		EchoOutputConfig echo = new EchoOutputConfig();
		DataRequestResponse resp;
		Status tempStatus;
		if (j.getInputType() == InputType.FILE) {
			resp = dss.read(new FileInputConfig(j.getInputPath()));
			tempStatus = resp.getStatus();
			if (tempStatus != Status.OK) {
				return new ComputationResult(tempStatus, null, null);
			}
			ints = resp.getValues();

		} else if (j.getInputType() == InputType.CSV) {
			resp = dss.read(new CsvInputConfig(j.getInputPath()));
			tempStatus = resp.getStatus();
			if (tempStatus != Status.OK) {
				return new ComputationResult(tempStatus, null, null);
			}
			ints = resp.getValues();
		}
		pair = j.getPairDelim();
		end = j.getEndDelim();
		while (ints.hasNext()) {
			exceptionChecker.add(threadPool.submit(computeTask(ints.next(), results, prev, next)));
			prev = next;
			next = new CountDownLatch(1);
			prev.countDown();
		}
		exceptionChecker.forEach(future -> {
			try {
				future.get();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});
		if (j.getOutputType() == OutputType.CLI) {
			// NoSuchElementException because the futures haven't actually been done.
			if (!dss.appendSingleResult(echo, results.removeFirst()).success()) {
				return new ComputationResult(Status.BAD, echo.getOutput(), OutputType.CLI);
			}
		} else if (j.getOutputType() == OutputType.FILE) {
			// NoSuchElementException because the futures haven't actually been done.
			if (!dss.appendSingleResult(new FileOutputConfig(j.getOutputPath()), results.removeFirst()).success()) {
				return new ComputationResult(Status.BAD, j.getOutputPath(), OutputType.FILE);
			}
		}
		return new ComputationResult(Status.OK,
				(j.getOutputType() == OutputType.FILE) ? j.getOutputPath() : echo.getOutput(), j.getOutputType());

	}

}
