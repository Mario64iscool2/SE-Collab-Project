package data;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import data.impl.DataStorageSystemImpl;

public class DataStorageSystemTest {

	@Test
	public void testDataStorageSystem() {
		// mock parameters
		CsvInputConfig mockIn = new CsvInputConfig("1,15,10,5,2,3,8");
		FileOutputConfig mockOutput = new FileOutputConfig("test/output.txt");
		IDataStorage dataStore = new DataStorageSystemImpl();
		Iterator<Integer> i = dataStore.read(mockIn).getValues();
		dataStore.appendSingleResult(mockOutput, i.next()+"result");
	}
}
