package datatests;

import java.util.ArrayList;
import java.util.List;

import data.OutputSource;
import utils.Status;

public class InMemoryOutput implements OutputSource {

	//made final to contain the mutability of the class
	private final List<String> output = new ArrayList<>();
	
	public List<String> getOutput() {
		return output;
	}

	@Override
	public Status write() {
		// TODO Auto-generated method stub
		return Status.BAD;
	}
}
