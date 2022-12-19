package com.awantunai.test.demo.auth.exception;

public class WrongCredentialException extends Exception {
    public WrongCredentialException() {
        super("Invalid password");
    }
}
