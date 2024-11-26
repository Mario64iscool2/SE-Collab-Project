package user;

public class JobSpec {
	String inputFilePath;
	public String getInputFilePath() {
		return inputFilePath;
	}

	public String getOutputFilePath() {
		return outputFilePath;
	}

	public char getPairDelim() {
		return pairDelim;
	}

	public char getEndDelim() {
		return endDelim;
	}

	String outputFilePath;
	char pairDelim, endDelim;
	
	public JobSpec(String i, String o, char p, char e) {
		this.inputFilePath =i;
		this.outputFilePath = o;
		this.pairDelim = p;
		this.endDelim = e;
	}
	
}
