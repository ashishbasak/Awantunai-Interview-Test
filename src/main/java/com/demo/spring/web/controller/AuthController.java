package com.demo.spring.web.controller;

import com.demo.spring.service.AuthService;
import com.demo.spring.web.model.request.SignInRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {

  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @PostMapping(value = "sign-in")
  public Mono<String> signIn(@RequestBody SignInRequest signInRequest) {
    return authService.signIn(signInRequest.getUsername(), signInRequest.getPassword());
  }
}
