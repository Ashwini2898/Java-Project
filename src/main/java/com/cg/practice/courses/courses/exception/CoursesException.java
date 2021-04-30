package com.cg.practice.courses.courses.exception;
public class CoursesException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String message;

	public CoursesException() {
		
	}

	public CoursesException(String message) {
		super(message);
		this.message=message;
	}
	
	public CoursesException(String message,Exception e) {
		super(message,e);
		this.message=message;
	}

	@Override
	public String toString() {
		return "ProductException [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}
	
	
}
