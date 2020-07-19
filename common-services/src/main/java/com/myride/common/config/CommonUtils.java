package com.myride.common.config;

import org.apache.commons.lang3.StringUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonUtils {
	
	public static String prepareAndGetResEnpointUrl(String baseUrl, String restEndPoint) {
		if(StringUtils.isNotEmpty(baseUrl) && StringUtils.isNotEmpty(restEndPoint)) {
			return baseUrl+restEndPoint;
		}else {
			return "";
		}
		
	}
}
