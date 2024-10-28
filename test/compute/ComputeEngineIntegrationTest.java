package compute;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import compute.impl.EngineImpl;
import compute.impl.NextPrimeCompute;
import datatests.InMemoryDataStore;
import datatests.InMemoryInput;
import datatests.InMemoryOutput;

public class ComputeEngineIntegrationTest {

	@Test
	public void testComputeEngine() {

		// Instantiate our Compute Core + Engine Pairing
		NextPrimeCompute compute = new NextPrimeCompute();
		EngineImpl engine = new EngineImpl(compute);
		
		// Create test input
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(10);
		list.add(25);

		// Create the data storage layer
		InMemoryInput input = new InMemoryInput(list);
		InMemoryOutput output = new InMemoryOutput();
		InMemoryDataStore dataStore = new InMemoryDataStore(input, output);

		// Compute
		String computationResult = engine.compute(dataStore);

		// Verification (two ways)
		Assertions.assertEquals("1,2;10,11;25,29;", computationResult);
		Assertions.assertArrayEquals(new String[] { "1,2;", "10,11;", "25,29;" }, output.getOutput().toArray());
	}
}
