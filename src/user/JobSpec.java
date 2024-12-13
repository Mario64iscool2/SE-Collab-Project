package user;

public class JobSpec implements IJobSpec {
	String inputFilePath;
	InputType inType;
	OutputType outType;
	
	@Override
	public InputType getInputType() {
		return inType;
	}

	@Override
	public OutputType getOutputType() {
		return outType;
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
		this.inType = iType;
		this.outType = oType;
	}

	@Override
	public String getInputPath() {
		// TODO Auto-generated method stub
		return inputFilePath;
	}

	@Override
	public String getOutputPath() {
		// TODO Auto-generated method stub
		return outputFilePath;
	}
	
	@Override
	public String toString() {
		return "{ Input: "+inputFilePath+", Output: "+outputFilePath+", Delimiters: [\""+pairDelim+"\", \""+endDelim.replaceAll("\r","\\\\r").replaceAll("\n", "\\\\n")+"\"], Input Type: "+inType.toString()+", Output Type: "+outType.toString()+" }";
	}
	
}
