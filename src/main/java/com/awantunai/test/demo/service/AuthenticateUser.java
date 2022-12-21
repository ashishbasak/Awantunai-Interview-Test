package com.awantunai.test.demo.service;

import com.awantunai.test.demo.dto.AuthenticateRequestBody;

public interface AuthenticateUser {
    public String authenticateUser(AuthenticateRequestBody authenticateRequestBody);
    public void addUserToHashMap();
}
