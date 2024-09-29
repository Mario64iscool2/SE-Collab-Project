package data;

public class DataStorage {
	public void prototype(DataStorageSystem dataStore) {
		InputSource inputSource = null;
		OutputSource outputSource = null;
		
		Iterable<Integer> loadedData = dataStore.read(inputSource);
		dataStore.writeTo(outputSource);
		
		for (int i : loadedData) {
			String result = "" + i;
			
			
			WriteResult writeResult = dataStore.appendSingleResult(outputSource, result);
			
			
			if (writeResult.getStatus() != WriteResult.WriteResultStatus.SUCCESS) {
				System.out.println("Failed!");
			}
		}
	}
}
