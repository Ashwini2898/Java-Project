package com.cg.practice.courses.courses.exception;
public class OperationFailedException extends RuntimeException {
 
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
 
    public OperationFailedException(String name) {
        super(name);
    }
}