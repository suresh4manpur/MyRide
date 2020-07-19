package com.myride.common.exception.handler;

import java.util.Optional;

import org.springframework.hateoas.mediatype.vnderrors.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.myride.common.exception.EntityNotFound;
import com.myride.common.exception.MyRideException;

@ControllerAdvice("com.myride")
@RequestMapping(produces = "application/vnd.error+json")
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFound.class)
	public ResponseEntity<VndErrors> notFoundException(EntityNotFound e) {
		return error(e, HttpStatus.NOT_FOUND, String.valueOf(e.getErrorCode()));
	}
	@ExceptionHandler(MyRideException.class)
	public ResponseEntity<VndErrors> notFoundException(MyRideException e) {
		return error(e, HttpStatus.INTERNAL_SERVER_ERROR, String.valueOf(e.getErrorCode()));
	}

	private <E extends Exception> ResponseEntity<VndErrors> error(final E exception, final HttpStatus httpStatus,
			final String logRef) {
		final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
		return new ResponseEntity<>(new VndErrors(logRef, message), httpStatus);
	}
}
