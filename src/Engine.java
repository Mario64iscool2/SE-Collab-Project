import java.util.Scanner;
public abstract class Engine implements IEngine, DataStorageSystem, User {

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
	@Override
	public int inputSource(){
	}
	@Override
	public char delimitercharacters(){
		Scanner sc=new Scanner(System.in);
		this.pair=sc.nextChar();
		this.end=sc.nextChar();
	}
	@Override
	public String outputDestination(){
	}
	public abstract String outputNext();

}
