package datatests;

import data.IDataStorage;
import utils.Status;

public class InMemoryDataStore implements IDataStorage {

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
	public Iterable<Integer> read() {
		if (memInput != null) {
			return memInput.getInputs();
		} else {
			return null;
		}
	}

	@Override
	public Status appendSingleResult(String result) {
		memOutput.write(result);
		return Status.OK;
	}

}
