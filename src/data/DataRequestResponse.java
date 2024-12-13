package data;

import java.util.Iterator;

import utils.Status;

/**
 * The response type the DataStore will give to the Coordinator when data is requested.
 */
public class DataRequestResponse {
	/**
	 * The operation's success
	 */
	private Status status;
	
	/**
	 * The iterator from our data.
	 */
	private final Iterator<Integer> values;
	
	/**
	 * Creates a DataRequestResponse Object containing the successfulness of reading the data, and the data (if any)
	 * @param s whether or not our data was successfully read
	 * @param v the iterable integers our data consists of
	 */
	public DataRequestResponse(Status s, Iterator<Integer> v) {
		status = s;
		values = v;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @return the values
	 */
	public Iterator<Integer> getValues() {
		return values;
	}
	
	
}
