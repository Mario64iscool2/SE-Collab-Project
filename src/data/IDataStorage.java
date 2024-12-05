package data;

import java.util.stream.IntStream;

import utils.Status;

/**
 * Manages File IO, given filepaths
 */
public interface IDataStorage {

	/**
	 * Retrieves the list of input integers to be iterated on for computation
	 * 
	 * @return An Iterable<Integer> (usually List-implementing) or null if the
	 *         DataStorageSystem doesn't have an input.
	 */
	DataRequestResponse readToIterator(InputSource in);

	Status appendSingleResult(OutputSource out, String result);

	/**
	 * Appends a single long result to a binary file if desired
	 * 
	 * @param result
	 * @return
	 */
	Status appendSingleRaw(OutputSource out, Long result);

	/**
	 * Sets the source and destination for the computation to read and write
	 * 
	 * @param src the source filepath as a String
	 * @param dst the destination filepath as a String
	 * @return Status.OK if the operation succeeded, or
	 *         some other status if not.
	 */
	Status setFilePaths(String src, String dst);

}
