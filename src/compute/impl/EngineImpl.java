package compute.impl;

import compute.Engine;
import compute.ICompute;
import data.DataStorageSystem;

public class EngineImpl extends Engine {

	/**
	 * Instantiate a new EngineImpl with the specified compute core, and default delimiters of ',' and ';'
	 * @param compute The computation core to use
	 */
	public EngineImpl(ICompute compute) {
		computation = compute;
		pair = ',';
		end = ';';
	}

	@Override
	public String compute(int i) {
		String result = Long.toString(i) + pair + computation.compute(i) + end;
		return result;
	}

	@Override
	public String compute(DataStorageSystem dss) {
		String result = "";
		for (Integer i : dss.read()) {
			String temp = compute(i);
			result += temp;
			dss.appendSingleResult(temp);
		}
		return result;
	}

}
