package com.dxc.prime;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping(value = "/{nthPrime}", method = RequestMethod.GET)
	public PrimeResponse findPrime(@PathVariable("nthPrime") int nthPrime) {
		StoredPrime prime = store.findOne(nthPrime);
		if (prime == null) {
			RestTemplate client = new RestTemplate();
			PrimeResponse primeResult = client.getForObject("http://localhost:8080/compute/" + nthPrime,
					PrimeResponse.class);
//			PrimeResponse primeResult = new PrimeResponse(-1L);
			prime = new StoredPrime(nthPrime, primeResult.getPrimeNumber());	
			store.save(prime);
		}
		return new PrimeResponse(prime.getPrimeNumber());
	}
}
