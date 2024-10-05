package datatests;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOutput {

	//made final to contain the mutability of the class
	private final List<String> output = new ArrayList<>();
	
	public List<String> getOutput() {
		return output;
	}
}
