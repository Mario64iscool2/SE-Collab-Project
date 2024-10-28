package data;

import utils.Status;

/**
 * Handles both input and output from the Engine.
 */
public interface DataStorageSystem {

	/**
	 * Retrieves the list of input integers to be iterated on for computation
	 * 
	 * @return An Iterable<Integer> (usually List-implementing) or null if the
	 *         DataStorageSystem doesn't have an input.
	 */
	Iterable<Integer> read();

	Status appendSingleResult(String result);

}
