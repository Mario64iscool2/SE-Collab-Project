package data.impl;

import data.DataStorageSystem;
import data.InputSource;
import data.OutputSource;
import utils.Status;

public class DataStorageSystemImpl implements DataStorageSystem {

	private InputSource input;
	private OutputSource output;

	public DataStorageSystemImpl(InputSource input, OutputSource output) {
		this.input = input;
		this.output = output;
	}

	@Override
	public Iterable<Integer> read() {
		return input.getInputs();
	}

	@Override
	public Status appendSingleResult(String result) {
		return output.write(result);
	}

}
