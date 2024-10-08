package datatests;

import data.DataStorageSystem;
import data.InputSource;
import data.OutputSource;
import utils.Status;

public class InMemoryDataStore implements DataStorageSystem {

	/**
	 * a test-only in-memory implementation of DataStorageSystem api
	 */

	public InMemoryDataStore(InMemoryInput imi, InMemoryOutput imo) {
		memInput = imi;
		memOutput = imo;
	}

	InMemoryInput memInput;
	InMemoryOutput memOutput;

	@Override
	public Iterable<Integer> read(InputSource inputSource) {
		if (inputSource != null) {
			return inputSource.getInputs();
		} else {
			return memInput.getInputs();
		}
	}

	@Override
	public Status writeTo(OutputSource outputSource) {
		((InMemoryOutput) outputSource).getOutput();
		return Status.OK;
	}

	@Override
	public Status appendSingleResult(OutputSource outputSource, String result) {
		((InMemoryOutput) outputSource).getOutput().add(result);
		return Status.OK;
	}

}
