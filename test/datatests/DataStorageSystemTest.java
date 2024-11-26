package datatests;

import org.mockito.Mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import data.IDataStorage;
import data.InputSource;
import data.OutputSource;
import data.impl.DataStorageSystemImpl;
import utils.Status;

public class DataStorageSystemTest {

	@Test
	public void testDataStorageSystem() {
		// mock parameters
		InputSource mockInput = Mockito.mock(InputSource.class);
		OutputSource mockOutput = Mockito.mock(OutputSource.class);

		IDataStorage dataStore = new DataStorageSystemImpl(mockInput, mockOutput);

		Assertions.assertEquals(4L, dataStore.read());

		Assertions.assertEquals(Status.OK, dataStore.appendSingleResult("result"));
	}
}
