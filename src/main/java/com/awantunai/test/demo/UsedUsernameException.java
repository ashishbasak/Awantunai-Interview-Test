package com.awantunai.test.demo;

public class UsedUsernameException extends RuntimeException {
    
    public UsedUsernameException(Long id) {
        super("User with " + id + " " + "same username");
    }
}
