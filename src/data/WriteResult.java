package data;

public interface WriteResult {
	WriteResultStatus getStatus();
	
	public enum WriteResultStatus {
		SUCCESS,
		FAILURE;
	}
 }
