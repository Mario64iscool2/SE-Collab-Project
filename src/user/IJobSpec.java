package user;

public interface IJobSpec {

	String getInputPath();
	
	String getOutputPath();
	
	InputType getInputType();
	
	OutputType getOutputType();

	String getPairDelim();

	String getEndDelim();

	
	public enum InputType {
		FILE,
		CSV
	}
	public enum OutputType {
		FILE,
		CLI
	}
	
}