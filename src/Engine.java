
public abstract class Engine implements IEngine, DataStorageSystem {

	// The pair delimiter
	private char pair;
	// The result delimiter
	private char end;
	@Override
	public void readInput(){
		setDelimiters(pair, end);
	}
	@Override
	public void writeTo(){
		this.readInput
		System.out.println(readInput());
	}
	@Override
	public void setDelimiters(char pair, char end) {
		// TODO Auto-generated method stub
		this.pair = pair;
		this.end = end;
	}

	@Override
	public boolean hasFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public abstract String outputNext();

}
