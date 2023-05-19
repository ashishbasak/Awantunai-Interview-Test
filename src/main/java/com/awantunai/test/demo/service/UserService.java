package com.awantunai.test.demo.service;

import com.awantunai.test.demo.dto.LoginRequest;
import com.awantunai.test.demo.dto.SignUpRequest;
import com.awantunai.test.demo.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> exists(String username);
    User create(SignUpRequest request);
    Optional<User> login(LoginRequest request);
}
