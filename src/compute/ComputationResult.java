package compute;

import user.IJobSpec.OutputType;
import utils.Status;

public class ComputationResult {
	final String output;
	final OutputType type;
	final utils.Status status;

	/**
	 * @param status Whether the computation succeeded or not and why
	 * @param output the output location of the computation, should match the input one.
	 */
	public ComputationResult(Status status, String output, OutputType type) {
		this.status = status;
		this.output = output;
		this.type = type;
	}

	public String getOutput() {
		return output;
	}

	public utils.Status getStatus() {
		return status;
	}
	
	public OutputType getType() {
		return type;
	}

}
