package com.project.onlineshoppingapp.exception;

import com.project.onlineshoppingapp.model.User;

public class PasswordMisMatchException extends RuntimeException {
	
	public PasswordMisMatchException(String message) {
		super(message);
	}

}
