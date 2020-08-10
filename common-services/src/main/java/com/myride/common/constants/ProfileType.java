package com.myride.common.constants;

public enum ProfileType {
	DRIVER("Driver", 1), RIDER("Rider", 2), OWNER("Owner", 3);

	private String label;
	private Integer code;

	private ProfileType(String label, Integer code) {
		this.label = label;
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public Integer getCode() {
		return code;
	}
	

}
