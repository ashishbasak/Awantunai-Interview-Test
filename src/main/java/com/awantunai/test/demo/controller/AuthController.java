package com.awantunai.test.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awantunai.test.demo.dto.request.LoginRequest;
import com.awantunai.test.demo.dto.request.SignupRequest;
import com.awantunai.test.demo.dto.response.LoginReponse;
import com.awantunai.test.demo.dto.response.SignupResponse;
import com.awantunai.test.demo.service.AuthService;

@RestController
@RequestMapping("auth")
public class AuthController {
    
    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public SignupResponse signup(@RequestBody() SignupRequest params) {
        SignupResponse result = authService.signup(params);
        return result;
    }

    @PostMapping("/login")
    public LoginReponse login(@RequestBody() LoginRequest params) {
        LoginReponse result = new LoginReponse();
        return result;
    }
}
