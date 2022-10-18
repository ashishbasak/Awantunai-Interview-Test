package com.awantunai.test.demo.dto.exception;

public class InvalidUserPasswordException extends Exception{

    public InvalidUserPasswordException(String message){
        super(message);
    }
}