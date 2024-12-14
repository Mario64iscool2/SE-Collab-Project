package harness;

import java.io.File;

import compute.IComputeCoordinator;
import user.IJobSpec.InputType;
import user.IJobSpec.OutputType;
import user.JobSpec;


public class TestUser {
	
	private final IComputeCoordinator coordinator;

	public TestUser(IComputeCoordinator coordinator) {
		this.coordinator = coordinator;
	}

	public void run(String outputPath) {
		char delimiter = ';';
		String inputPath = "test" + File.separatorChar + "testInputFile.test";
		
		// TODO 4: Call the appropriate method(s) on the coordinator to get it to 
		// run the compute job specified by inputPath, outputPath, and delimiter
		
		JobSpec j = new JobSpec(inputPath,outputPath,",",""+delimiter,InputType.FILE,OutputType.FILE);
		coordinator.compute(j);
		
	}

}
