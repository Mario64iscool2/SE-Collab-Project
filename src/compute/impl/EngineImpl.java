package compute.impl;

import compute.Engine;
import compute.ICompute;
import data.DataStorageSystem;
import data.InputSource;
import data.OutputSource;

public class EngineImpl extends Engine {

	public EngineImpl(ICompute compute) {
		computation = compute;
	}
	private Iterable<Integer> integerList;

	@Override
	public String compute(int i, OutputSource dst) {
		long result = computation.compute(i);

		return Long.toString(result);
	}

	@Override
	public String compute(InputSource src, OutputSource dst) {
		long result = 0;
		
		// result = computation.compute()
		return Long.toString(result);
	}

}
