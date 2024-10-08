package compute;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import compute.impl.EngineImpl;
import data.InputSource;
import data.OutputSource;

public class EngineTest {

	@Test
	public void testEngine() {
		//mock parameters
		ICompute mockICompute = Mockito.mock(ICompute.class);
		
		//mock class
		Engine engine = new EngineImpl(mockICompute);
		
		//mock Output
		OutputSource dst = Mockito.mock(OutputSource.class);
		
		//test compute(int i, OutputSource dst)
		Assertions.assertEquals("result", engine.compute(7, dst));
		
		//mock input
		InputSource src = Mockito.mock(InputSource.class);
		
		//test compute(InputSource<?> src, OutputSource dst)
		Assertions.assertEquals("result", engine.compute(src, dst));
		
		
	
	}

}
