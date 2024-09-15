
public abstract class Engine implements IEngine {

	// The pair delimiter
	private char _pair;
	// The result delimiter
	private char _end;
	
	@Override
	public void setDelimiters(char pair, char end) {
		// TODO Auto-generated method stub
		_pair = pair;
		_end = end;
	}

	@Override
	public boolean hasFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public abstract String outputNext();

}
