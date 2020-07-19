package com.myride.common.exception;

public class MyRideException extends RuntimeException{

	private static final long serialVersionUID = -2679410092899960681L;
	
	private Integer errorCode;

    public MyRideException(String message) {
        super(message);
    }

    public MyRideException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyRideException(String message, Throwable cause, Integer errorCode) {
        super(message, cause);
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
