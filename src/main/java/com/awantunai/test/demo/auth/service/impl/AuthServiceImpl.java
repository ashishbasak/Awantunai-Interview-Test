package com.awantunai.test.demo.auth.service.impl;

import com.awantunai.test.demo.auth.dto.SignInRequest;
import com.awantunai.test.demo.auth.dto.SignInResponse;
import com.awantunai.test.demo.auth.dto.SignUpRequest;
import com.awantunai.test.demo.auth.exception.AccountNotFoundException;
import com.awantunai.test.demo.auth.exception.WrongCredentialException;
import com.awantunai.test.demo.auth.model.User;
import com.awantunai.test.demo.auth.repository.UserRepository;
import com.awantunai.test.demo.auth.service.AuthService;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {
    UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signUp(SignUpRequest signUpRequest) throws NoSuchAlgorithmException {
        User user = new User(
                UUID.randomUUID(),
                signUpRequest.getEmail(),
                this.hashPassword(signUpRequest.getPassword()),
                signUpRequest.getName(),
                signUpRequest.getAddress(),
                signUpRequest.getAge()
        );

        this.userRepository.storeUser(user);
    }

    @Override
    public SignInResponse signIn(SignInRequest signInRequest) throws AccountNotFoundException, WrongCredentialException, NoSuchAlgorithmException {
        User user = this.userRepository.getUserByEmail(signInRequest.getEmail());

        if (user == null) {
            throw new AccountNotFoundException(signInRequest.getEmail());
        }

        if (!this.hashPassword(signInRequest.getPassword()).equals(user.getPassword())) {
            throw new WrongCredentialException();
        }

        return new SignInResponse(
                this.generateAuthToken(user.getId())
        );
    }

    private String hashPassword(String plain) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        byte[] hash = digest.digest(
                plain.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private String generateAuthToken(UUID userId) {
        return "jwt-" + userId.toString();
    }
}
