package data;

import utils.Status;

public interface IDataStorage {

	/**
	 * Retrieves the list of input integers to be iterated on for computation
	 * 
	 * @return An Iterable<Integer> (usually List-implementing) or null if the
	 *         DataStorageSystem doesn't have an input.
	 */
	DataRequestResponse read(InputConfig in);

	Status appendSingleResult(OutputConfig out, String result);

}
