package utils;

/**
 * A status enum for process-boundary communication. Feel free to add additional
 * statuses if you'd like.
 */
public enum Status {
	/**
	 * Used for successful completion of an operation.
	 */
	OK(true),
	/**
	 * General failure to compute server-side due to file write error or other computation error
	 */
	BAD(false),
	/**
	 * The server cannot parse the input given.
	 */
	BAD_INPUT(false);

	private final boolean success;

	private Status(boolean success) {
		this.success = success;
	}

	/**
	 * Whether or not the value of this enum is equivalent to a success.
	 * @return true if this enum is {@link Status#OK} false otherwise.
	 */
	public boolean success() {
		return success;
	}
}
