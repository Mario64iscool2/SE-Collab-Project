package data;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import data.IDataStorage;
import data.InputConfig;
import data.OutputConfig;
import data.impl.DataStorageSystemImpl;
import utils.Status;

public class DataStorageSystemTest {

	@Test
	public void testDataStorageSystem() {
		// mock parameters
		InputConfig mockIn = Mockito.mock(InputConfig.class);
		ArrayList<Integer> e = new ArrayList<Integer>();
		e.add(4);
		OutputConfig mockOutput = Mockito.mock(OutputConfig.class);
		IDataStorage dataStore = new DataStorageSystemImpl();

		Assertions.assertEquals(4, dataStore.read(mockIn).getValues().iterator().next());

		Assertions.assertEquals(Status.OK, dataStore.appendSingleResult(mockOutput, "result"));
	}
}
