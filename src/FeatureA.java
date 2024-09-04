// Star-imports are frowned upon by checkstyles.
import java.io.*;
public class FeatureA {
	
	public static void main(String[] args)
	{
		FeatureA a = new FeatureA();
		a.Test();
	}
	
	//Checkstyles dislikes methods starting with a capital letter
	void Test(){
		System.out.println("This is a test of legal java code that violates Check-Styles");
	}
}
