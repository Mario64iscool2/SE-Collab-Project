package compute.impl;

import compute.ComputationResult;
import compute.Coordinator;
import compute.ICore;
import data.FileInputConfig;
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
	 * @param compute The computation core to use
	 */
	public CoordinatorImpl(ICore compute, IDataStorage dss) {
		computation = compute;
		pair = ",";
		end = ";";
		this.dss = dss;
	}

	@Override
	public ComputationResult compute(IJobSpec j) {
		String cliString = "";
		if (j.getInputType() == InputType.FILE) {
			ints = dss.read(new FileInputConfig(j.getInputPath())).getValues();
		} else if (j.getInputType() == InputType.CSV) {
			ints = dss.read(new FileInputConfig(j.getInputPath())).getValues();
		}
		pair = j.getPairDelim();
		end = j.getEndDelim();
		for (int i : ints) {
			String temp = formatOutput(i);
			if (j.getOutputType() == OutputType.CLI) {
				cliString += temp;
			} else {
				if (!dss.appendSingleResult(null, temp).success()) {
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
