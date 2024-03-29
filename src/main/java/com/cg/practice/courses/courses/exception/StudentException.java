package com.cg.practice.courses.courses.exception;

public class StudentException extends Exception {
private static final long serialVersionUID = 1L;
	
	private String message;

	public StudentException() {
		
	}

	public StudentException(String message) {
		super(message);
		this.message=message;
	}
	
	public StudentException(String message,Exception e) {
		super(message,e);
		this.message=message;
	}

	@Override
	public String toString() {
		return "CustomerException [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}
	
}
