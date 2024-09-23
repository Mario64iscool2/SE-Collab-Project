package utils;

public enum Status {
	OK(true),
	BAD(false);
	
	private boolean success;
	
	private Status(boolean success) {
		this.success = success;
	}
	public boolean success() {
		return success;
	}
}
