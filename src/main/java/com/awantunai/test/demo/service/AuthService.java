package com.awantunai.test.demo.service;

import com.awantunai.test.demo.dto.LoginRequestDto;
import com.awantunai.test.demo.dto.RegisterRequestDto;

public interface AuthService {

  void login(LoginRequestDto loginRequestDto);

  void signUp(RegisterRequestDto registerRequestDto);
}
