package compute;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import compute.impl.EngineImpl;
import data.InputSource;
import data.OutputSource;

public class EngineTest {

	/**
	 * Blanket test of Compute Engine Wrapper.
	 */
	@Test
	public void testEngine() {
		// Generate mock ICompute-implementer that will just output 11.
		ICompute mockICompute = Mockito.mock();
		Mockito.when(mockICompute.compute(Mockito.anyInt())).thenReturn(11L);
		EngineImpl eng = new EngineImpl(mockICompute);
		eng.setDelimiters(',', ';');
		assertEquals("1,11;", eng.compute(1));
	}

}
