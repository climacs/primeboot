package com.dxc.prime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_PRIME")
public class StoredPrime {
	@Id
	@Column(name = "NTH_PRIME")
	private Integer nthPrime;

	@Column(name = "PRIME_NUMBER")
	private long primeNumber;	

	public StoredPrime() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StoredPrime(Integer nthPrime, long primeNumber) {
		super();
		this.nthPrime = nthPrime;
		this.primeNumber = primeNumber;
	}

	public Integer getNthPrime() {
		return nthPrime;
	}

	public void setNthPrime(Integer nthPrime) {
		this.nthPrime = nthPrime;
	}

	public long getPrimeNumber() {
		return primeNumber;
	}

	public void setPrimeNumber(long primeNumber) {
		this.primeNumber = primeNumber;
	}

}
