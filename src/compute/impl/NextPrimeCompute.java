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
		long j = 1;
		// If i+j is nonprime, iterate until it is.
		while (!isPrimeImproved(j+i))
		{
			j++;
		}
		return j+i;
	}

	/**
	 * Recursively computes the primeness of an integer, iterating until we find a
	 * prime.
	 * 
	 * @param i the integer whose primeness is being checked.
	 * @return the next greatest number that is prime
	 * @deprecated (Stack Overflow is bad.)
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
	 * that is a square is automatically composite and that the only even prime is
	 * 2.
	 * 
	 * @author Cameron Jarvis
	 * @param val the integer whose primeness is being tested.
	 * @return the boolean truth of whether <b>val</b> is prime or not.
	 */
	boolean isPrimeImproved(long val) {
		// 1 and any number below it are nonprime.
		if (val <= 1) {
			return false;
		}
		// 2 is the only even prime, so we explicitly check it.
		if (val == 2) {
			return true;
		}
		// Any even number greater than 2 will be composite
		if (val % 2 == 0) {
			return false;
		}
		// Since every even number greater than 2 is composite by definition of even, we
		// only need to iterate along odds.
		for (long i = 3; i <= Math.floor(Math.sqrt(val)); i += 2) {
			if (val % i == 0) {
				return false;
			}
		}
		return true;
	}

}
