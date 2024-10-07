package compute;

import java.util.ArrayList;

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
		
		InMemoryDataStore dataStore = new InMemoryDataStore();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(10);
		list.add(25);
		
		InMemoryInput input = new InMemoryInput(list);
		InMemoryOutput output = new InMemoryOutput();
		
		//compute
		
		//use assertEquals() to test if it was successful
		
	}
}
