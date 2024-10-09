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

		ICompute iCompute = new NextPrimeCompute();
		Engine engine = new EngineImpl(iCompute);

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(10);
		list.add(25);

		InMemoryInput input = new InMemoryInput(list);
		InMemoryOutput output = new InMemoryOutput();

		InMemoryDataStore dataStore = new InMemoryDataStore(input, output);

		// compute
		String computationResult = engine.compute(input, output);

		// use assertEquals() to test if it was successful
		Assertions.assertEquals(output.getOutput(),
				new ArrayList<>(Arrays.asList(computationResult.split(Character.toString(engine.pair)))));
	}
}
