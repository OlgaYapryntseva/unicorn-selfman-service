package com.selfman.provider.products.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ProductForbiddenExeption extends RuntimeException {
	private static final long serialVersionUID = -3738890149901221086L;

}
