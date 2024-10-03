package data;

import utils.Status;

/**
 * Handles both input and output from the Engine.
 */
public interface DataStorageSystem {

	Iterable<Integer> read(InputSource<?> inputSource);
	
	Status writeTo(OutputSource outputSource);
	
	Status appendSingleResult(OutputSource outputSource, String result);


}
