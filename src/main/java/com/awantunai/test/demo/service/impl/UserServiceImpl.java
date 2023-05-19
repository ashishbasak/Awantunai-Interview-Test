package com.awantunai.test.demo.service.impl;

import com.awantunai.test.demo.dto.LoginRequest;
import com.awantunai.test.demo.dto.SignUpRequest;
import com.awantunai.test.demo.model.User;
import com.awantunai.test.demo.repository.UserRepository;
import com.awantunai.test.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> exists(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User create(SignUpRequest request) {
        final User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .build();
        return userRepository.save(user);
    }

    @Override
    public Optional<User> login(LoginRequest request) {
        return userRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
    }

    private String encrypt(String password) {
        return "";
        // TODO:
    }
}
