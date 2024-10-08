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
	public Iterable<Integer> read(InputSource inputSource) {
		return null;
	}

	@Override
	public Status writeTo(OutputSource outputSource) {
		return Status.BAD;
	}

	@Override
	public Status appendSingleResult(OutputSource outputSource, String result) {
		return Status.BAD;
	}

}
