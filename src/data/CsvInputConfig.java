package data;

public class CsvInputConfig implements InputConfig {
	
	private final String data;
	
	public String getCsv() {
		return data;
	}
	
	public CsvInputConfig(String data) {
		this.data = data;
	}
	
}
