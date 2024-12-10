package compute.smoke_tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import compute.impl.NextPrimeCompute;

public class CoreTest {
	@Test
	void testCore() {
		NextPrimeCompute core = new NextPrimeCompute();
		assertEquals(2, core.compute(1));
		
	}
	
}
