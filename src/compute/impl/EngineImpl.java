package compute.impl;

import compute.Engine;
import compute.ICompute;
import data.OutputSource;

public class EngineImpl extends Engine {

	public EngineImpl(ICompute compute) {
		computation = compute;
	}

	@Override
	public String compute(int i, OutputSource dst) {
		long result = computation.compute(i);

		return Long.toString(result);
	}

}
