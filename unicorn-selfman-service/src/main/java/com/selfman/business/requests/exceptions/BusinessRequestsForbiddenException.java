package com.selfman.business.requests.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class BusinessRequestsForbiddenException extends RuntimeException{
	private static final long serialVersionUID = 5356922643494768160L;

}
