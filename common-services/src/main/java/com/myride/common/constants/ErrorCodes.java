package com.myride.common.constants;

public enum ErrorCodes {
	
	ENTITY_NOT_FOUND(1000, "Entity not found."), 
	INVALID_ENTITY(1002, "Invalid request entity."),
	INTERNAL_SERVER_ERROR(1003, "Something went wrong while processing the request!");

	private int errorCode;
	private String errorDescription;

	private ErrorCodes(int errorCode, String errorDescription) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

}
