package com.myride.common.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {
	private Integer errorCode;
	private String errorType;
	private String errorMessage;

}
