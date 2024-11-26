package prototype;

import compute.ComputationResult;
import compute.ICore;
import user.JobSpec;
import utils.Status;

public class CoordinatorProto {
	JobSpec spec;
	ICore computation;
	Iterable<Integer> inputs;
	public ComputationResult compute(ICore computation) {
		CoordinatorProto proto = new CoordinatorProto();
		for(int i : inputs) {
			long temp = computation.compute(i);
			// temp.toString();
			// append to out.
		}
		return new ComputationResult(Status.OK,proto.spec.getOutputFilePath());
	}

}
