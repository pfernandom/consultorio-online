package com.consultorio.core.exceptions;

public class ElementNotPersistedException extends RuntimeException {

	private static final long serialVersionUID = -8894194713441067070L;
	
	public ElementNotPersistedException() {
		super("The element could not be persisted");
	}
	
	public ElementNotPersistedException(Throwable e) {
		super("The element could not be persisted", e);
	}

	public ElementNotPersistedException(String userId) {
		super("Could not persist user '" + userId + "'.");
	}
}
