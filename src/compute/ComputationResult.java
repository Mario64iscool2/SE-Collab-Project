package compute;

import user.IJobSpec.OutputType;
import utils.Status;

public class ComputationResult {
	final String output;
	final OutputType type;
	final utils.Status status;

	/**
	 * @param status Whether the computation succeeded or not and why
	 * @param output The output location of the computation, should match the input one.
	 * @param type The type of output, specified during job send
	 */
	public ComputationResult(Status status, String output, OutputType type) {
		this.status = status;
		this.output = output;
		this.type = type;
	}

	/**
	 * A publicly retrievable String containing the output location.
	 * @return
	 */
	public String getOutput() {
		return output;
	}

	/**
	 * A publicly retrievable Status of the operation.
	 * @return the {@link Status#OK} of the operation
	 */
	public utils.Status getStatus() {
		return status;
	}
	
	/**
	 * A publicly retrievable type of the output file
	 * @return the {@link OutputType} of the output file
	 */
	public OutputType getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return "{ Status: "+status.toString()+", Output Location: "+output+", Output Type: "+type.toString()+"}";
	}

}
