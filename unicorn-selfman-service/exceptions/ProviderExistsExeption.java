package com.selfman.provider.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ProviderExistsExeption extends RuntimeException {
	private static final long serialVersionUID = -3738890149901221086L;

}
