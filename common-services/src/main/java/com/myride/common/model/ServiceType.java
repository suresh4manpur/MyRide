package com.myride.common.model;

public enum ServiceType {
	CAB_REGISTRATION("cab registration"),
	CAB_BOOKING("cab booking"),
	DRIVER_REGISTRATION("driver registration"),
	RIDER_REGISTRATION("rider registration");
	
	private String label;

	private ServiceType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
}
