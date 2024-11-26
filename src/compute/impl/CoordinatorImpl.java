package compute.impl;

import compute.ComputationResult;
import compute.Coordinator;
import compute.ICore;
import user.JobSpec;
import data.IDataStorage;
import data.impl.DataStorageSystemImpl;

public class CoordinatorImpl extends Coordinator {

	
	private JobSpec spec;
	private DataStorageSystemImpl dss;
	/**
	 * Instantiate a new CoordinatorImpl with the specified compute core, and default
	 * delimiters of ',' and ';'
	 * 
	 * @param compute The computation core to use
	 */
	public CoordinatorImpl(ICore compute) {
		computation = compute;
		pair = ',';
		end = ';';
	}

	@Override
	public ComputationResult compute(JobSpec j) {
		spec = j;
		String result = "";
		for (int i : dss.readToIterator()) {
			String temp = compute(i);
			result += temp;
			appendSingleResult(temp);
		}
		return result;
	}

	@Override
	public ComputationResult compute(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
