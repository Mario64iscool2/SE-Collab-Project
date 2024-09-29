package data.impl;
import data.DataStorageSystem;
import data.InputSource;
import data.OutputSource;
import data.WriteResult;
public class DataStorageSystemImpl implements DataStorageSystem{
	
	private OutputSource output;
	private InputSource input;
	public DataStorageSystemImpl(InputSource input, OutputSource output) {
		this.input = input;
		this.output = output;
	}
	@Override
	public Iterable<Integer> read(InputSource inputSource) {
		return null;
	}
	@Override
	public void writeTo(OutputSource outputSource) {
		
	}
	@Override
	public WriteResult appendSingleResult(OutputSource outputSource, String result) {
		return null;
	}

}
