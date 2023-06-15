package com.awantunai.test.demo.exception;

public class WrongCredentialsException extends RuntimeException {
    private String message;
    public WrongCredentialsException(String message) {
        super(message);
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
