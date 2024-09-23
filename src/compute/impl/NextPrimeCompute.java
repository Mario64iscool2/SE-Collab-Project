package compute.impl;
import compute.ICompute;

public class NextPrimeCompute implements ICompute {

	@Override
	public long compute(int i) {
		if (isPrime(i)) {
			return i;
		} else {
			return -1;
		}
	}

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

}
