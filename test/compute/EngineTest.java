package compute;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import compute.impl.EngineImpl;

public class EngineTest {

	/**
	 * Blanket test of Compute Engine Wrapper.
	 */
	@Test
	public void testCoordinator() {
		// Generate mock ICompute-implementer that will just output 11.
		ICore mockICompute = Mockito.mock();
		Mockito.when(mockICompute.compute(Mockito.anyInt())).thenReturn(11L);
		IComputeCoordinator coord = new EngineImpl(mockICompute);
		assertEquals("1,11;", coord.compute(1));
	}

}
