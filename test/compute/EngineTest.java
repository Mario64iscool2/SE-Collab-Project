package compute;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import compute.impl.EngineImpl;

public class EngineTest {

	@Test
	public void testEngine() {
		EngineImpl eng = new EngineImpl(mock());
		eng.compute(1, mock());
	}

}
