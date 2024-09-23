package data;

import utils.Status;

public interface OutputSource {

	// Likely to just be a wrapper for an output file, whether it be console, binary, etc.
	public Status write(String data);
	
}
