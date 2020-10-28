package com.example.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	//Contrutor
	public ResourceNotFoundException(Object id) {
		super("Resource not found. id" + id);
	}
}
