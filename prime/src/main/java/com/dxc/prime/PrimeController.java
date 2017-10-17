package com.dxc.prime;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeController {
	@RequestMapping(method = RequestMethod.GET, //
			value = "/compute/{nthPrime}", //
			produces = MediaType.APPLICATION_JSON_VALUE) //

	public PrimeResponse register(@PathVariable int nthPrime) {
		PrimeCalculator calculator = new PrimeCalculator();

		return new PrimeResponse(calculator.getPrime(nthPrime));
	}

	@ExceptionHandler
	void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {

		response.sendError(HttpStatus.BAD_REQUEST.value());

	}
}
