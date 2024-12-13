package compute.impl;

import compute.ComputationResult;
import compute.Coordinator;
import compute.ICore;
import data.DataRequestResponse;
import data.FileInputConfig;
import data.FileOutputConfig;
import data.IDataStorage;
import user.IJobSpec;
import user.IJobSpec.InputType;
import user.IJobSpec.OutputType;
import utils.Status;

public class CoordinatorImpl extends Coordinator {

	private IDataStorage dss;

	Iterable<Integer> ints;

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
		String cliString = "";
		DataRequestResponse resp;
		Status tempStatus;
		if (j.getInputType() == InputType.FILE) {
			resp = dss.read(new FileInputConfig(j.getInputPath()));
			tempStatus = resp.getStatus();
			if(tempStatus != Status.OK) {
				return new ComputationResult(tempStatus, null, null);
			}
			ints = resp.getValues();
			
		} else if (j.getInputType() == InputType.CSV) {
			resp = dss.read(new FileInputConfig(j.getInputPath()));
			tempStatus = resp.getStatus();
			if(tempStatus != Status.OK) {
				return new ComputationResult(tempStatus, null, null);
			}
			ints = resp.getValues();
		}
		pair = j.getPairDelim();
		end = j.getEndDelim();
		for (int i : ints) {
			String temp = formatOutput(i);
			if (j.getOutputType() == OutputType.CLI) {
				cliString += temp;
			} else {
				if (!dss.appendSingleResult(new FileOutputConfig(j.getOutputPath()), temp).success()) {
					return new ComputationResult(Status.BAD, null, null);
				}
			}
		}
		return new ComputationResult(Status.OK, j.getOutputPath(), j.getOutputType());
	}

	private String formatOutput(int i) {
		return "" + i + pair + computation.compute(i) + end;
	}

}
