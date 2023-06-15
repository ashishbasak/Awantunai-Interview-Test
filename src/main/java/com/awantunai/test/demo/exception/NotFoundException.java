package com.awantunai.test.demo.exception;

public class NotFoundException extends RuntimeException{
    private String message;

    public NotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
