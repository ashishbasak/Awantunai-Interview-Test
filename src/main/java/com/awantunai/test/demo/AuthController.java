package com.awantunai.test.demo;

import com.awantunai.test.demo.auth.dto.ApiResponse;
import com.awantunai.test.demo.auth.dto.SignInRequest;
import com.awantunai.test.demo.auth.dto.SignInResponse;
import com.awantunai.test.demo.auth.dto.SignUpRequest;
import com.awantunai.test.demo.auth.exception.AccountNotFoundException;
import com.awantunai.test.demo.auth.exception.WrongCredentialException;
import com.awantunai.test.demo.auth.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController("/auth")
public class AuthController {
    AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ApiResponse<String> signUp(@RequestBody SignUpRequest signUpRequest) {
        ApiResponse<String> response;
        try {
            this.authService.signUp(signUpRequest);

            response = new ApiResponse("Register is successful");
        } catch (NoSuchAlgorithmException e) {
            response = new ApiResponse(500, "Internal Server Error");
        }

        return response;
    }

    @PostMapping("/signin")
    public ApiResponse<SignInResponse> signUp(@RequestBody SignInRequest signInRequest) {
        ApiResponse<SignInResponse> response;
        try {
            SignInResponse signInResponse = this.authService.signIn(signInRequest);

            response = new ApiResponse(signInResponse);
        } catch (NoSuchAlgorithmException e) {
            response = new ApiResponse(500, "Internal Server Error");
        } catch (WrongCredentialException e) {
            response = new ApiResponse(403, e.getMessage());
        } catch (AccountNotFoundException e) {
            response = new ApiResponse(401, e.getMessage());
        }

        return response;
    }
}
