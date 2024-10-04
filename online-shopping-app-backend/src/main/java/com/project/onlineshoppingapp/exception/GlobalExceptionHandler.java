package com.project.onlineshoppingapp.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserAlreadyExistsException.class)
	public @ResponseBody ErrorResponse handleException(UserAlreadyExistsException ex) {
		log.info("UserAlreadyExists Exception Handler Working.");
		return new ErrorResponse(LocalDateTime.now(),HttpStatus.CONFLICT.value(), ex.getMessage());
	}
	
	@ExceptionHandler(UserNotFound.class)
	public @ResponseBody ErrorResponse handleException(UserNotFound ex) {
		log.info("UserNotFound Exception Handler Working.");
		return new ErrorResponse(LocalDateTime.now(),HttpStatus.NOT_FOUND.value(),ex.getMessage());
	}
	
	public @ResponseBody ErrorResponse handleException(PasswordMisMatchException ex) {
		log.warn("PasswordMisMatchException Handler Working");
		return new ErrorResponse(LocalDateTime.now(),HttpStatus.UNAUTHORIZED.value(),ex.getMessage());
	}
	
	
	
	
}
