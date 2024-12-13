package compute.smoke_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import compute.ComputationResult;
import compute.IComputeCoordinator;
import compute.ICore;
import compute.impl.CoordinatorImpl;
import data.DataRequestResponse;
import data.IDataStorage;
import data.InputSource;
import data.impl.CsvInput;
import user.JobSpec;
import user.IJobSpec.InputType;
import user.IJobSpec.OutputType;
import utils.Status;

public class CoordinatorTest {

	/**
	 * Blanket test of Compute Engine Wrapper.
	 */
	@Test
	public void testCoordinator() {
		// Generate mock ICompute-implementer that will just output 11.
		ICore mockICompute = Mockito.mock();
		InputSource mockIn = new CsvInput("42");
		IDataStorage mockIDataStorage = Mockito.mock();
		Mockito.when(mockIDataStorage.read(Mockito.any()))
				.thenReturn(new DataRequestResponse(Status.OK, mockIn.getInputs()));
		Mockito.when(mockIDataStorage.appendSingleResult(Mockito.any(), Mockito.anyString())).thenReturn(Status.OK);
		Mockito.when(mockICompute.compute(Mockito.anyInt())).thenReturn(11L);
		ArrayList<Integer> testVal = new ArrayList<Integer>();
		testVal.add(42);
		IComputeCoordinator coord = new CoordinatorImpl(mockICompute, mockIDataStorage);
		ComputationResult cr = coord.compute(new JobSpec("", "", ",", ";", InputType.CSV, OutputType.CLI));
		assertEquals(Status.OK, cr.getStatus());

	}

}
