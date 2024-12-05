package user;

public interface IJobSpec {

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