package compute;

import utils.Status;

public class ComputationResult {
	final String outputLocation;
	final utils.Status status;

	/**
	 * @param status Whether the computation succeeded or not and why
	 * @param outputLocation the output location of the computation, should match the input one.
	 */
	public ComputationResult(Status status, String outputLocation) {
		this.status = status;
		this.outputLocation = outputLocation;
	}

	public String getOutputLocation() {
		return outputLocation;
	}

	public utils.Status getStatus() {
		return status;
	}

}
