package prototype;

import data.FileInputConfig;
import data.IDataStorage;
import utils.Status;
/**
 * Coordinator-POV onto Storage interaction
 */
public class DataStoragePrototype {
	CoordinatorProto proto;
	public void prototype(IDataStorage dataStore) {		
		Iterable<Integer> loadedData = dataStore.read(new FileInputConfig("")).getValues();

		for (int i : loadedData) {
			String result = "" + i;

			Status status = dataStore.appendSingleResult(null,result);

			if (status != Status.OK) {
				System.out.println("Failed!");
			}
		}
	}
}
