package compute;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import compute.impl.EngineImpl;
import data.OutputSource;


public class EngineTest {

	@Test
	public void testEngine()
	{
		EngineImpl eng = new EngineImpl(mock());
		eng.compute(1,mock());
	}
	
}
