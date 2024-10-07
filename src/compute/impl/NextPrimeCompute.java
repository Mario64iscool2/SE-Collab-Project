package compute.impl;
import compute.ICompute;

/**
 * Computes the first prime number greater than the input.
 * 
 * @author Cameron Jarvis
 */
public class NextPrimeCompute implements ICompute {

	@Override
	public long compute(int i) {
		// If our starting value is prime, we need to start from the next integer, as
		// we're looking for the next greatest prime.
		/**
  		* @author Gavin Bell
    		* validation test
      		*/
		boolean vtest=false;
		while(vtest=false){
			if(isInteger(i)==true){
				vtest=true;
			} else {
				System.out.println("Invalid: Not an integer");
			}
		return isPrimeImproved(i) ? recursiveCompute(i + 1) : recursiveCompute(i);
	}
	boolean isInteger(Object obj) { 
		return obj instanceof Integer; 
	}

	/**
	 * Recursively computes the primeness of an integer, iterating until we find a
	 * prime.
	 * 
	 * @param i the integer whose primeness is being checked.
	 * @return the next greatest number that is prime
	 */
	public long recursiveCompute(int i) {
		return isPrimeImproved(i) ? i : recursiveCompute(i + 1);
		
	}

	/**
	 * Determines whether or not an integer is prime.
	 * 
	 * @author Gavin Bell
	 * @param x the integer whose primeness is being checked.
	 * @deprecated use {@link NextPrimeCompute#isPrimeImproved(int)}
	 * @return the boolean truth of whether x is prime or not.
	 */
	boolean isPrime(int x) {
		if (x <= 1) {
			return false;
		}
		for (int i = 2; i < x; i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Determines the primeness of an integer. Uses the optimization that any number
	 * that is a square is automatically composite.
	 * 
	 * @author Cameron Jarvis
	 * @param val the integer whose primeness is being tested.
	 * @return the boolean truth of whether <b>val</b> is prime or not.
	 */
	boolean isPrimeImproved(int val) {
		if (val <= 1) {
			return false;
		}
		for (int i = 2; i < Math.floor(Math.sqrt(val)); i++) {
			if (val % i == 0) {
				return false;
			}
		}
		return true;
	}

}
