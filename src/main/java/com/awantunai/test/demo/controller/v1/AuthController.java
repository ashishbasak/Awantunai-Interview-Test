package com.awantunai.test.demo.controller.v1;

import com.awantunai.test.demo.dto.LoginRequestDto;
import com.awantunai.test.demo.dto.RegisterRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1/auth")
public class AuthController {

  @PostMapping("/login")
  public void login(@RequestBody LoginRequestDto loginRequestDto) {

  }

  @PostMapping("/register")
  public void signUp(@RequestBody RegisterRequestDto registerRequestDto) {

  }
}
