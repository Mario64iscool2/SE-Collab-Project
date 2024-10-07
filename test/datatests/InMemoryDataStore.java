package datatests;
import data.DataStorageSystem;
import data.InputSource;
import data.OutputSource;
import utils.Status;
public class InMemoryDataStore implements DataStorageSystem{

	/**
	 * a test-only in-memory implementation of DataStorageSystem api
	 */
	
	@Override
	public Iterable<Integer> read(InputSource<?> inputSource) {
		return ((InMemoryInput)inputSource).getInputs();
	}

	@Override
	public Status writeTo(OutputSource outputSource) {
		((InMemoryOutput)outputSource).getOutput();
		return Status.OK;
	}

	@Override
	public Status appendSingleResult(OutputSource outputSource, String result) {
		((InMemoryOutput)outputSource).getOutput().add(result);
		return Status.OK;
	}

}
