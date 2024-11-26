package prototype;
import compute.ComputationResult;
import compute.IComputeCoordinator;
import user.JobSpec;
import utils.Status;

public class UserProto {
	IComputeCoordinator coordinator;
	
	public static void main(String[] args) {
		UserProto proto = new UserProto();
		JobSpec spec = new JobSpec(null,null,',',';');
		ComputationResult res = proto.coordinator.compute(spec);
		if(res.getStatus()==Status.OK)
		{
			System.out.print("Yippee!!");
		}
	}
	
}
