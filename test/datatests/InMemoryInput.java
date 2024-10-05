package datatests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InMemoryInput {
	
	//make immutable
	private final List<Integer> inputs = new ArrayList<>();
	
	
	public InMemoryInput(Collection<Integer> inputs) {
		this.inputs.addAll(inputs);
		}
	
	//return new arraylist to maintain immutability
	public List<Integer> getInputs() {
		return new ArrayList<>(inputs);
	}

}
