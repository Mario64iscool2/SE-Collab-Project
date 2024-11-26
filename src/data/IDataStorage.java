package data;

import java.io.File;
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
	Iterable<Integer> readToIterator();
	IntStream readToStream();

	Status appendSingleResult(String result);
	
	/**
	 * Appends a single long result to a binary file if desired
	 * @param result
	 * @return
	 */
	Status appendSingleRaw(Long result);

	Status setFilePaths(String src, String dst);
	
}
