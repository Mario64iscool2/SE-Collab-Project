package compute;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import compute.impl.CoordinatorImpl;
import compute.impl.NextPrimeCompute;
import datatests.InMemoryDataStore;
import datatests.InMemoryInput;
import datatests.InMemoryOutput;
import user.IJobSpec;
import user.JobSpec;

public class ComputeEngineIntegrationTest {

	@Test
	public void testComputeEngine() {

		// Create test input
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(10);
		list.add(25);
		// Create the data storage layer
		InMemoryInput input = new InMemoryInput(list);
		InMemoryOutput output = new InMemoryOutput();
		InMemoryDataStore dataStore = new InMemoryDataStore(input, output);
		// Instantiate our Compute Core + Engine Pairing
		NextPrimeCompute compute = new NextPrimeCompute();
		CoordinatorImpl engine = new CoordinatorImpl(compute,dataStore);

		// Job Specification
		IJobSpec j = new JobSpec(null,null,",",";",IJobSpec.InputType.CSV,IJobSpec.OutputType.FILE);
		// Compute
		ComputationResult computationResult = engine.compute(j);

		// Verification (two ways)
		Assertions.assertEquals("1,2;10,11;25,29;", computationResult);
		Assertions.assertArrayEquals(new String[] { "1,2;", "10,11;", "25,29;" }, output.getOutput().toArray());

	}
}
