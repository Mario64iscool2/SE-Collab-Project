package data;

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
	public DataRequestResponse read(InputConfig in) {
		if (memInput != null) {
			return new DataRequestResponse(Status.OK, memInput.getInputs().iterator());
		} else {
			return null;
		}
	}

	@Override
	public Status appendSingleResult(OutputConfig out, String result) {
		return memOutput.write(result);
	}

}
