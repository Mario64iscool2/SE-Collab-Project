package compute;

import data.DataStorageSystem;

/**
 * Outlines the outward-facing methods that our computation engine must have.
 * 
 * @author mario64iscool2
 *
 */
interface IEngine {
	/**
	 * Sets the output delimiters (characters between input/result pairs and between
	 * results)
	 * 
	 * @param pair delimits the input integer from the result
	 * @param end  delimits results from one another
	 */
	void setDelimiters(char pair, char end);

	/**
	 * Retrieves the completed job's result
	 * 
	 * @param dss A data-storage implementation that is read/write capable.
	 * @return a string containing the job's result.
	 */
	public abstract String compute(DataStorageSystem dss);

	/**
	 * If the input is a single integer, use this.
	 * 
	 * @param i The integer input to be operated on
	 * @return The result as a string for this single computation
	 */
	public abstract String compute(int i);
}