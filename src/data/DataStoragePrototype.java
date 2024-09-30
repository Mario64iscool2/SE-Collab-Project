package data;

import utils.Status;

public class DataStoragePrototype {
	public void prototype(DataStorageSystem dataStore) {
		InputSource inputSource = null;
		OutputSource outputSource = null;

		Iterable<Integer> loadedData = dataStore.read(inputSource);
		dataStore.writeTo(outputSource);

		for (int i : loadedData) {
			String result = "" + i;

			Status status = dataStore.appendSingleResult(outputSource, result);

			if (status != Status.OK) {
				System.out.println("Failed!");
			}
		}
	}
}
