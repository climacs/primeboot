package com.dxc.prime;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/primes")
public class PrimeStoreController {

	@Autowired
	private PrimeStore store;

	@Value("${endpoint.prime}")
	private String primeEndpoint;

	@CrossOrigin
	@RequestMapping(value = "/{nthPrime}", method = RequestMethod.GET)
	public PrimeResponse findPrime(@PathVariable("nthPrime") int nthPrime) {
		StoredPrime prime = store.findOne(nthPrime);
		if (prime == null) {
			RestTemplate client = new RestTemplate();
			PrimeResponse primeResult = client.getForObject(primeEndpoint + nthPrime, PrimeResponse.class);
			// System.out.println("primeEndpoint: " + primeEndpoint);
			// PrimeResponse primeResult = new PrimeResponse(-1L);
			prime = new StoredPrime(nthPrime, primeResult.getPrimeNumber());
			store.save(prime);
		}
		return new PrimeResponse(prime.getPrimeNumber());
	}

	@CrossOrigin
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public PrimeListResponse findAll() {
		List<StoredPrime> storedPrimes = store.findAll();
		List<Prime> primes = new ArrayList<>();
		for (StoredPrime storedPrime : storedPrimes) {
			primes.add(new Prime(storedPrime.getNthPrime(), storedPrime.getPrimeNumber()));
		}
		return new PrimeListResponse(primes);
	}
}
