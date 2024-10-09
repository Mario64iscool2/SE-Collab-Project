package data;

import java.util.List;

import utils.Status;

public interface OutputSource {

	public List<String> getOutput();
	
	public Status write(String s);
	
}
