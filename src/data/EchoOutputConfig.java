package data;

public class EchoOutputConfig implements OutputConfig {

	StringBuilder out = new StringBuilder();
	
	public void append(String result) {
		out.append(result);
	}
	
	public String getOutput() {
		return out.toString();
	}
	
}
