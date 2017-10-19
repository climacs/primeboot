package com.dxc.prime;

import java.util.List;

public class PrimeListResponse {
	public List<Prime> primes;

	public PrimeListResponse(List<Prime> primes) {
		super();
		this.primes = primes;
	}

	public PrimeListResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Prime> getPrimes() {
		return primes;
	}

	public void setPrimes(List<Prime> primes) {
		this.primes = primes;
	}

}
