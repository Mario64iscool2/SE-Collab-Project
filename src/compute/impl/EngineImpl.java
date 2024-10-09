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

	@Override
	public String compute(int i, OutputSource dst) {
		String result = Long.toString(i)+pair+computation.compute(i)+end;
		return result;
	}

	@Override
	public String compute(InputSource src, OutputSource dst) {
		String result = "";
		for (Integer i : src.getInputs()) {
			result += compute(i, dst);
		}
		dst.write(result);
		return result;
	}

}
