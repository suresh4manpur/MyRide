package com.myride.common.constants;

public enum RestEndpoints {
	NOTIFICATION_SERVICE_SEND_MAIL("/v1/send-mail");
	
	private String restEndPoinUrl;

	private RestEndpoints(String restEndPoinUrl) {
		this.restEndPoinUrl = restEndPoinUrl;
	}

	public String getRestEndPoinUrl() {
		return restEndPoinUrl;
	}
	
}
