package com.myride.common.exception.handler;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.myride.common.error.ApiError;
import com.myride.common.exception.EntityNotFound;
import com.myride.common.exception.InvalidRequestException;
import com.myride.common.exception.MyRideException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice("com.myride")
@Slf4j
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	/**
	 * If any entity not found from database then <h>EntityNotFound exception should be thrown from service and would be captured.
	 * @param e
	 * @return
	 */
	@ExceptionHandler(EntityNotFound.class)
	public ResponseEntity<ApiError> notFoundException(EntityNotFound e) {
		logError(e);
		return error(e, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MyRideException.class)
	public ResponseEntity<ApiError> notFoundException(MyRideException e) {
		logError(e);
		return error(e, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(InvalidRequestException.class)
	public ResponseEntity<ApiError> invalidException(InvalidRequestException e) {
		logError(e);
		return error(e, HttpStatus.BAD_REQUEST);
	}
	private void logError(RuntimeException e) {
		log.error(e.getMessage(), e);
	}

	private <E extends Exception> ResponseEntity<ApiError> error(final MyRideException exception, final HttpStatus httpStatus) {
		final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
		
		ApiError apiError = new ApiError(exception.getErrorCode(),httpStatus.getReasonPhrase(), message);

		return new ResponseEntity<ApiError>(apiError, httpStatus);
	}
}

