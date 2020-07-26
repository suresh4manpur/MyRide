package com.myride.common.exception;

public class InvalidRequestException extends MyRideException{

	private static final long serialVersionUID = -2679410092899960681L;
	
	private Integer errorCode;
	

    public InvalidRequestException(String message) {
        super(message);
    }

    public InvalidRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRequestException(String message, Throwable cause, Integer errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }
    public Integer getErrorCode() {
        return errorCode;
    }

}
