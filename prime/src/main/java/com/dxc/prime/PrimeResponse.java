package com.dxc.prime;

public class PrimeResponse {
	private long primeNumber;

	public PrimeResponse(long primeNumber) {
		super();
		this.primeNumber = primeNumber;
	}

	public long getPrimeNumber() {
		return primeNumber;
	}

	public void setPrimeNumber(int primeNumber) {
		this.primeNumber = primeNumber;
	}

}
