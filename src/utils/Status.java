package utils;

/**
 * A status enum for process-boundary communication. Feel free to add additional
 * statuses if you'd like.
 */
public enum Status {
	OK(true), BAD(false);

	private boolean success;

	private Status(boolean success) {
		this.success = success;
	}

	public boolean success() {
		return success;
	}
}
