package com.example.course.services.exceptions;

public class DatabaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	//construtor padrão
	public DatabaseException(String msg) {
		super(msg);
	}
}
