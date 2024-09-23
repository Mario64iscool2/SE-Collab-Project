package compute;

import data.InputSource;
import data.OutputSource;

/** Outlines the outward-facing methods that our computation engine must have.
 * @author mario64iscool2
 *
 */
interface IEngine {
	/**
	 * Sets the output delimiters (characters between input/result pairs and between results)
	 * @param pair delimits the input integer from the result
	 * @param end delimits results from one another
	 */
	void setDelimiters(char pair, char end);
	/**
	 * Retrieves the completed job's result
	 * @param src An input Source of some kind that can be interpreted as a sequence of {@code int}s
	 * @param dst An output of some kind that can take our results.
	 * @implNote Data store management will run parallel to this interface, as to get from InputSource to {@code int}, we will need to manipulate the incoming information.
	 * @return a string containing the job's result.
	 */
	public abstract String compute(InputSource<?> src, OutputSource dst);
	
	public abstract String compute(int i, OutputSource dst);

	public default String compute() {
		return "No Computation Available";
	}
}
abstract class aPIimplementation implements IEngine{
}
