package com.consultorio.webapp.rest.exception;

public class PatientNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8894194713441067070L;
	
	public PatientNotFoundException() {
		super("No patient was found");
	}

	public PatientNotFoundException(String userId) {
		super("Could not find user '" + userId + "'.");
	}
}
