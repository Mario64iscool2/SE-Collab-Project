package data.impl;

import java.io.File;
import java.io.FileReader;
import java.util.stream.IntStream;

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
	public Status appendSingleResult(String result) {
		return out.write(result);
	}

	@Override
	public Iterable<Integer> readToIterator() {
		return in.getInputs();
	}

	@Override
	public IntStream readToStream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status appendSingleRaw(Long result) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status setFilePaths(String src, String dst) {
		boolean err = false;
		try {
			
			
		} catch (Exception e) {
			e.printStackTrace();
			err = true;
		}
		return err ? Status.OK : Status.BAD;
	}

}
