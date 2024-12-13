package data.impl;

import java.util.List;

import data.InputSource;

public class DirectInputSource implements InputSource {

	private List<Integer> inputs;

	@Override
	public List<Integer> getInputs() {
		// TODO Auto-generated method stub
		return inputs;
	}

	public DirectInputSource() {
	}

	public DirectInputSource(List<Integer> vals) {
		inputs = vals;
	}

}
