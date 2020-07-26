package com.myride.common.exception;

public class EntityNotFound extends MyRideException{
	
	private static final long serialVersionUID = 8863960911317807507L;
	
	private Integer errorCode;

    public EntityNotFound(String message) {
        super(message);
    }

    public EntityNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFound(String message, Throwable cause, Integer errorCode) {
        super(message, cause);
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
