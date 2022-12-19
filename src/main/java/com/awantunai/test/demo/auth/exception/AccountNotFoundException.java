package com.awantunai.test.demo.auth.exception;

public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String email) {
        super("User with email " + email + " is not exist");
    }
}
