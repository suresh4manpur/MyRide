package com.myride.common.constants;

public enum CabType {
	
	MICRO("Micro",0), MINI("Mini",1), PRIME_SEDAN("Prime Sedan",2), SUV("SUV",3);

	private String label;
	private Integer code;

	private CabType(String label, Integer code) {
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
