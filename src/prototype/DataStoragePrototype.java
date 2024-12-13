package prototype;

import java.util.Iterator;

import data.FileInputConfig;
import data.IDataStorage;
import utils.Status;
/**
 * Coordinator-POV onto Storage interaction
 */
public class DataStoragePrototype {
	CoordinatorProto proto;
	public void prototype(IDataStorage dataStore) {		
		Iterator<Integer> loadedData = dataStore.read(new FileInputConfig("")).getValues();

		while (loadedData.hasNext()) {
			String result = "" + loadedData.next();

			Status status = dataStore.appendSingleResult(null,result);

			if (status != Status.OK) {
				System.out.println("Failed!");
			}
		}
	}
}
