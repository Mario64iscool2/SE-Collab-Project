package prototype;

import compute.ComputationResult;
import compute.IComputeCoordinator;
import user.IJobSpec;
import user.IJobSpec.InputType;
import user.IJobSpec.OutputType;
import user.JobSpec;
import utils.Status;

public class UserProto {
	IComputeCoordinator coordinator;

	public static void main(String[] args) {
		UserProto proto = new UserProto();
		IJobSpec spec = new JobSpec(null, null, ",", ";", InputType.CSV, OutputType.CLI);
		ComputationResult res = proto.coordinator.compute(spec);
		if (res.getStatus() == Status.OK) {
			System.out.print("Yippee!!");
		}
	}

}
