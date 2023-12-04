package com.selfman.customer.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CustomerExistsExeption extends RuntimeException{

	private static final long serialVersionUID = 1700736900044059623L;

	public CustomerExistsExeption(String message) {
		super(message);
	}

	
	
	 

}
