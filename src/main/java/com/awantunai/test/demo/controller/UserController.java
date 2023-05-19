package com.awantunai.test.demo.controller;

import com.awantunai.test.demo.dto.LoginRequest;
import com.awantunai.test.demo.dto.SignUpRequest;
import com.awantunai.test.demo.model.User;
import com.awantunai.test.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@RequestBody SignUpRequest request) {
        if (validateRequest(request.getUsername(), request.getPassword())) {
            return ResponseEntity.badRequest().build();
        }

        if (!userService.exists(request.getUsername()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        try {
            userService.create(request);
        } catch (Exception ex) {
            log.error("Error when creating new user", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginRequest request) {
        if (validateRequest(request.getUsername(), request.getPassword())) {
            return ResponseEntity.badRequest().build();
        }

        Optional<User> userOptional;
        try {
            userOptional = userService.login(request);
        } catch (Exception ex) {
            log.error("Error finding user", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        if (userOptional.isPresent()) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    private boolean validateRequest(String username, String password) {
        return  (StringUtils.isEmpty(username) || StringUtils.isEmpty(password));
    }
}
