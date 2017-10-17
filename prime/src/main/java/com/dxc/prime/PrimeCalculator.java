package com.dxc.prime;

public class PrimeCalculator {
	public static void main(String[] args) {
		PrimeCalculator prime = new PrimeCalculator();
		System.out.println("thePrime:" + prime.getPrime(100));
	}

	public long getPrime(int nth) {
		int numToTest = 2;
		for (int pctr = 1; pctr < nth; pctr++) {
			boolean primeFound = false;
			while (!primeFound) {
				numToTest++;
				primeFound = checkPrime(numToTest);
				if (numToTest == 700) {
					return -1L;
				}
			}
		}
		return numToTest;
	}

	private boolean checkPrime(int numToTest) {

		if (isEven(numToTest)) {
			return false;
		}

		return isPrime(numToTest);
	}

	private boolean isEven(int numToTest) {
		return numToTest % 2 == 0;
	}

	private boolean isPrime(int numToTest) {
		for (int factor = 3; factor < numToTest; factor += 2) {
			if (numToTest % factor == 0) {
				return false;
			}
		}
		return true;
	}
}
