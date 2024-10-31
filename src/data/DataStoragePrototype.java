package data;

import utils.Status;

public class DataStoragePrototype {
	public void prototype(DataStorageSystem dataStore) {

		Iterable<Integer> loadedData = dataStore.read();

		for (int i : loadedData) {
			String result = "" + i;

			Status status = dataStore.appendSingleResult(result);

			if (status != Status.OK) {
				System.out.println("Failed!");
			}
		}
	}
}
