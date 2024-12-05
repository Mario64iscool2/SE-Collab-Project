package user;

public class JobSpec implements IJobSpec {
	String inputFilePath;
	@Override
	public InputType getInputType() {
		return InputType.FILE;
	}

	@Override
	public OutputType getOutputType() {
		return OutputType.FILE;
	}

	@Override
	public String getPairDelim() {
		return pairDelim;
	}

	@Override
	public String getEndDelim() {
		return endDelim;
	}

	String outputFilePath;
	String pairDelim, endDelim;
	
	public JobSpec(String in, String out, String pair, String end, InputType iType, OutputType oType) {
		this.inputFilePath = in;
		this.outputFilePath = out;
		this.pairDelim = pair;
		this.endDelim = end;
	}
	
}
