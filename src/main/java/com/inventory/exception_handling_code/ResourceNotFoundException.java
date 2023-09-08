package com.inventory.exception_handling_code;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);

		
	}

	public ResourceNotFoundException() {

	}
}