package com.myride.registration.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Authenticator;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyRideApiExceptionHandler extends ResponseEntityExceptionHandler{

	
	/*
	 * @@Override protected ResponseEntity<Object>
	 * handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders
	 * header,WebRequest request) { return null;
	 * 
	 * 
	 * }
	 */
	protected ResponseEntity<Object> handleNoHandlerFoundException(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return null;
	   // String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();
	 
	   // ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), error);
	   // return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

}
