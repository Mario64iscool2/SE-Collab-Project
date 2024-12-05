package datatests;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(4);
		OutputSource mockOutput = Mockito.mock(OutputSource.class);

		IDataStorage dataStore = new DataStorageSystemImpl();
		

		Assertions.assertEquals(4L, dataStore.readToIterator(mockInput).getValues());

		Assertions.assertEquals(Status.OK, dataStore.appendSingleResult(mockOutput,"result"));
	}
}
