
/**
 * @author mario64iscool2
 *
 */
public interface IEngine {
	/**
	 * Sets the output delimiters (characters between input/result pairs and between results)
	 * @param pair delimits the input integer from the result
	 * @param end delimits results from one another
	 */
	void setDelimiters(char pair, char end);
	/**
	 * Retrieves the next output string
	 * @return a string containing the input for this computation, the delimiting character, and the resultant output.
	 */
	public abstract String outputNext();
	/**
	 * Whether or not the active computation(s) have finished
	 * @return a boolean truth value of whether or not the computation engine has completed the computation.
	 */
	boolean hasFinished();
}
