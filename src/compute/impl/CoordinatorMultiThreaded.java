package compute.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import compute.ComputationResult;
import compute.Coordinator;
import compute.ICore;
import data.CsvInputConfig;
import data.DataRequestResponse;
import data.FileInputConfig;
import data.FileOutputConfig;
import data.IDataStorage;
import user.IJobSpec;
import user.IJobSpec.InputType;
import user.IJobSpec.OutputType;
import utils.Status;
import java.util.concurrent.*;

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
	private Callable<Long> computeTask(int num, List<String> result, CountDownLatch prev, CountDownLatch next) {
		return () -> {
			String s = formatOutput(num);
			next.await();
			result.add(s);
			prev.countDown();
			return null;
		};
	}

	@Override
	public ComputationResult compute(IJobSpec j) {
		List<String> results = new ArrayList<>();
		ExecutorService threadPool = Executors.newCachedThreadPool();
		List<Future<?>> exceptionChecker = new ArrayList<>();
		CountDownLatch prev = new CountDownLatch(1);
		CountDownLatch next = new CountDownLatch(1);
		String cliString = "";
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
			for (int i = 0; i < 8; i++) {
				exceptionChecker.add(threadPool.submit(computeTask(ints.next(), results, prev, next)));
				prev = next;
				next = new CountDownLatch(1);
			}
			prev.countDown();
			exceptionChecker.forEach(future -> {
				try {
					future.get();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			});
		}
		for (String result : results) {
			if(!dss.appendSingleResult(new FileOutputConfig(j.getOutputPath()), result).success()) {
				throw new RuntimeException("Write Failed!");
			}
		}
		return new ComputationResult(Status.OK, j.getOutputPath(), j.getOutputType());
	}

	private String formatOutput(int i) {
		return "" + i + pair + computation.compute(i) + end;
	}

}
