package com.consultorio.core.dataaccess.entity;

public enum BloodType {
	A_POSITIVE("A+"), A_NEGATIVE("A-"), B_POSITIVE("B+"), B_NEGATIVE("B-"), AB_POSITIVE("AB+"), AB_NEGATIVE(
			"AB-"), O_POSITIVE("O+"), O_NEGATIVE("O-");
	private final String label;

	private BloodType(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return label;
	}
}