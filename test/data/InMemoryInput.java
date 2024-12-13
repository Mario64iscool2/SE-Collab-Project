package data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import data.InputSource;

public class InMemoryInput implements InputSource {

	// make immutable
	private final List<Integer> inputs = new ArrayList<>();

	public InMemoryInput(Collection<Integer> inputs) {
		this.inputs.addAll(inputs);
	}

	// return new arraylist to maintain immutability
	public List<Integer> getInputs() {
		return new ArrayList<>(inputs);
	}
}
