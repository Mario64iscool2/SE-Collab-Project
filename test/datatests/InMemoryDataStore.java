package datatests;

import data.DataRequestResponse;
import data.IDataStorage;
import data.InputSource;
import data.OutputSource;
import data.impl.DirectInputSource;
import data.impl.EchoOut;
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
	public DataRequestResponse readToIterator(InputSource in) {
		if (memInput != null) {
			return new DataRequestResponse(Status.OK,memInput.getInputs());
		} else {
			return null;
		}
	}

	@Override
	public Status appendSingleResult(OutputSource out, String result) {
		return memOutput.write(result);
	}
	
	@Override
	public Status appendSingleRaw(OutputSource out, Long result) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status setFilePaths(String src, String dst) {
		return Status.OK;
	}

}
