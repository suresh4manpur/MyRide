package com.myride.registration.constants;

public enum RegistrationStatus {
	NEW("New"), INPROGRESS("InProgress"), PENIDING("Pending"), REJECTED("Rejected"), APPROVED("Approved");

	private String label;

	private RegistrationStatus(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
