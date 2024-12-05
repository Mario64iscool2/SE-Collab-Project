package data.impl;

import data.DataRequestResponse;
import data.IDataStorage;
import data.InputSource;
import data.OutputSource;
import utils.Status;

public class DataStorageSystemImpl implements IDataStorage {

	InputSource in;
	OutputSource out;

	public DataStorageSystemImpl() {
	}

	@Override
	public Status appendSingleResult(OutputSource out, String result) {
		return out.write(result);
	}

	@Override
	public DataRequestResponse readToIterator(InputSource in) {
		if(in != null)
		{
			return new DataRequestResponse(Status.OK, in.getInputs());
		}
		return new DataRequestResponse(Status.OK, this.in.getInputs());
	}

	@Override
	public Status appendSingleRaw(OutputSource out, Long result) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status setFilePaths(String src, String dst) {
		
		if(src == null | src == "") {
			in = new DirectInputSource();
		}
		if(dst == null | dst == "") {
			out = new EchoOut();
		}
		return Status.OK;
	}

}
