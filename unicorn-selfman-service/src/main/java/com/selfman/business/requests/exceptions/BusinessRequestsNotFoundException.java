package com.selfman.business.requests.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BusinessRequestsNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 7278438094123204518L;

}
