package com.awantunai.test.demo.controller;

import com.awantunai.test.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.FailedLoginException;

@RestController
public class UserController {
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping(path = "/login")
  public ResponseEntity<?> login(@RequestParam("username") String username, @RequestParam("password") String password) throws FailedLoginException {
    boolean isValid = userService.verify(username, password);

    if (!isValid) {
      throw new FailedLoginException();
    }

    return ResponseEntity.accepted().build();
  }
}
