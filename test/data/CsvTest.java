package data;

import org.junit.jupiter.api.Test;

import data.impl.CsvInput;

public class CsvTest {

	public CsvTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testRegex() {
		CsvInput csv = new CsvInput("1, 2,3,4,5, -100 99");
		System.out.println(csv.getInputs().toString());
	}

}
