package compute.impl;

import java.util.Iterator;

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

public class CoordinatorImpl extends Coordinator {

	private IDataStorage dss;

	Iterator<Integer> ints;

	/**
	 * Instantiate a new CoordinatorImpl with the specified compute core, and
	 * default delimiters of ',' and ';'
	 * 
	 * @param mockICompute The computation core to use
	 */
	public CoordinatorImpl(ICore mockICompute, IDataStorage dss) {
		computation = mockICompute;
		pair = ",";
		end = ";";
		this.dss = dss;
	}

	@Override
	public ComputationResult compute(IJobSpec j) {
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
			String temp = formatOutput(ints.next());
			if (j.getOutputType() == OutputType.CLI) {
				if (!dss.appendSingleResult(echo, temp).success()) {
					return new ComputationResult(Status.BAD, null, null);
				}
			} else if (j.getOutputType() == OutputType.FILE) {
				if (!dss.appendSingleResult(new FileOutputConfig(j.getOutputPath()), temp).success()) {
					return new ComputationResult(Status.BAD, null, null);
				}
			}
		}
		return new ComputationResult(Status.OK,
				(j.getOutputType() == OutputType.FILE) ? j.getOutputPath() : echo.getOutput(), j.getOutputType());
	}

	private String formatOutput(int i) {
		return "" + i + pair + computation.compute(i) + end;
	}

}
