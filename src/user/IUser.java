package user;

import utils.Status;

public interface IUser {
	
	/**
	 * Sets the job source file location
	 * @param path the string denoting the file path of the input.
	 * @return the status of the set. Can return a falsy value when the file location is not valid.
	 */
	public Status setSource(String path);
	/**
	 * Sets the destination file location
	 * @param path the desired target location as a string.
	 * @return the status of the set. Can return a falsy value if the file location doesn't have write access, or the storage drive is nearly full.
	 */
	public Status setDestination(String path);

	/**
	 * Calls to start the computation processes given the source and destination supplied to this object.
	 */
	public void startJob();
	
}
