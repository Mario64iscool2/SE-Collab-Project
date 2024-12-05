package compute.impl;

import compute.ComputationResult;
import compute.Coordinator;
import compute.ICore;
import utils.Status;
import data.IDataStorage;
import data.impl.DataStorageSystemImpl;
import user.IJobSpec;
import user.IJobSpec.InputType;

public class CoordinatorImpl extends Coordinator {

	private IDataStorage dss;
	/**
	 * Instantiate a new CoordinatorImpl with the specified compute core, and default
	 * delimiters of ',' and ';'
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
		if(j.getInputType() == InputType.FILE)
		{
			
		}
		pair = j.getPairDelim();
		end = j.getEndDelim();
		for (int i : dss.readToIterator(null).getValues()) {
			String temp = ""+i+pair+computation.compute(i)+end;
			if(!dss.appendSingleResult(null, temp).success())
			{
			}
		}
		return new ComputationResult();
	}

}
