package data;

import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import org.junit.jupiter.api.Test;


import data.impl.DataStorageSystemImpl;

public class DataStorageSystemTest {
	@Test
	public void testDataStorageSystem() {
		DataStorageSystemImpl mockDataSystem = Mockito.mock(DataStorageSystemImpl.class);

		when(mockDataSystem.hasFinished()).thenReturn(true);
	}
}
