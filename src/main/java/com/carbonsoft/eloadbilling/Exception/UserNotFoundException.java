package com.carbonsoft.eloadbilling.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6236983173186552360L;

	public UserNotFoundException(String message) {
		super(message);
	}

}
