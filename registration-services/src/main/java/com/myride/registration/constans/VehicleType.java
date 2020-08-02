package com.myride.registration.constans;

public enum VehicleType {
	MICRO("Micro"), MINI("Mini"), PRIME_SEDAN("Prime Sedan"), SUV("SUV");

	private String label;

	private VehicleType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
