package datatests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import data.IDataStorage;
import data.InputSource;
import data.OutputSource;
import data.impl.CsvInput;
import data.impl.DataStorageSystemImpl;
import utils.Status;

public class CsvTest {

	public CsvTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void testRegex()
	{
		CsvInput csv = new CsvInput("1, 2,3,4,5, -100 99");
		System.out.println(csv.getInputs().toString());
	}

}
