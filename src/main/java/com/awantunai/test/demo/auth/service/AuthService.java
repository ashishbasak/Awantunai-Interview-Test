package com.awantunai.test.demo.auth.service;

import com.awantunai.test.demo.auth.dto.SignInRequest;
import com.awantunai.test.demo.auth.dto.SignInResponse;
import com.awantunai.test.demo.auth.dto.SignUpRequest;
import com.awantunai.test.demo.auth.exception.AccountNotFoundException;
import com.awantunai.test.demo.auth.exception.WrongCredentialException;

import java.security.NoSuchAlgorithmException;

public interface AuthService {
    void signUp(SignUpRequest signUpRequest) throws NoSuchAlgorithmException;
    SignInResponse signIn(SignInRequest signUpRequest) throws AccountNotFoundException, WrongCredentialException, NoSuchAlgorithmException;
}
