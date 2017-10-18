package com.dxc.prime;

public class PrimeCalculator {
	public static void main(String[] args) {
		PrimeCalculator prime = new PrimeCalculator();
		System.out.println("thePrime:" + prime.getPrime(100));
	}

	public long getPrime(int nth) {
		long numToTest = 2;
		for (int pctr = 1; pctr < nth; pctr++) {
			boolean primeFound = false;
			while (!primeFound) {
				numToTest++;
				primeFound = checkPrime(numToTest);
//				if (numToTest == 32767) {
//					return -1L;
//				}
			}
		}
//		return numToTest+1;
		return numToTest;
	}

	private boolean checkPrime(long numToTest) {

		if (isEven(numToTest)) {
			return false;
		}

		return isPrime(numToTest);
	}

	private boolean isEven(long numToTest) {
		return numToTest % 2 == 0;
	}

	private boolean isPrime(long numToTest) {
		for (long factor = 3; factor < numToTest; factor += 2) {
			if (numToTest % factor == 0) {
				return false;
			}
		}
		return true;
	}
}
