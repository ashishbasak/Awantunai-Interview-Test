package com.awantunai.test.demo.auth.dto;

public class SignInRequest {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public SignInRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
