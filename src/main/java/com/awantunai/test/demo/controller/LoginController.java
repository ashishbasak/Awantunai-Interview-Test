package com.awantunai.test.demo.controller;

import com.awantunai.test.demo.model.User;
import com.awantunai.test.demo.request.LoginDto;
import com.awantunai.test.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {

    private UserService userService;
    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid LoginDto loginDto) {
        User user = userService.getLogin(loginDto.getUsername(), loginDto.getPassword());
        return ResponseEntity.ok(user);
    }
}
