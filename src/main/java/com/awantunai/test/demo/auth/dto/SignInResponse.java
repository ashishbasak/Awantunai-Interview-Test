package com.awantunai.test.demo.auth.dto;

public class SignInResponse {
    String token;

    public String getToken() {
        return token;
    }

    public SignInResponse(String token) {
        this.token = token;
    }
}
