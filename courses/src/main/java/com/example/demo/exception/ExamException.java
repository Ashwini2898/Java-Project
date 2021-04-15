package com.example.demo.exception;

public class ExamException extends Exception {
	
private static final long serialVersionUID = 1L;
	
	private String message;

	public ExamException() {
		
	}

	public ExamException(String message) {
		super(message);
		this.message=message;
	}
	
	public ExamException(String message,Exception e) {
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
