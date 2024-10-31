package data;

import java.util.List;

import utils.Status;

public interface OutputSource {

	/**
	 * Returns the output integers, in1, out1, in2, out2, etc.
	 * 
	 * @return
	 */
	public List<String> getOutput();

	/**
	 * Writes the input string to the output.
	 * 
	 * @param s the string to write.
	 * @return Status.OK if the write succeeded, and Status.BAD if not.
	 */
	public Status write(String s);

}
