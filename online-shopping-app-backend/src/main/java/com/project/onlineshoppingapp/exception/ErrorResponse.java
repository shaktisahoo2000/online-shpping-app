package com.project.onlineshoppingapp.exception;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class ErrorResponse {

	private LocalDateTime timeStamp;
	private int statusCode;
	private String message;
	
	public ErrorResponse(LocalDateTime timeStamp, int statusCode, String message) {
		super();
		this.timeStamp = timeStamp;
		this.statusCode = statusCode;
		this.message = message;
	}

}
