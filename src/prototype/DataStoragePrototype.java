package prototype;

import data.IDataStorage;
import utils.Status;
/**
 * Coordinator-POV onto Storage interaction
 */
public class DataStoragePrototype {
	CoordinatorProto proto;
	public void prototype(IDataStorage dataStore) {
		dataStore.setFilePaths(proto.spec.getInputFilePath(), proto.spec.getOutputFilePath());
		Iterable<Integer> loadedData = dataStore.readToIterator();

		for (int i : loadedData) {
			String result = "" + i;

			Status status = dataStore.appendSingleResult(result);

			if (status != Status.OK) {
				System.out.println("Failed!");
			}
		}
	}
}
