package com.awantunai.test.demo.service.impl;

import com.awantunai.test.demo.dto.CreatePilotRequestDto;
import com.awantunai.test.demo.dto.LoginRequestDto;
import com.awantunai.test.demo.dto.RegisterRequestDto;
import com.awantunai.test.demo.service.AuthService;
import com.awantunai.test.demo.service.PilotService;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final PilotService pilotService;

  @Override
  public void login(LoginRequestDto loginRequestDto) {

  }

  @Override
  public void signUp(RegisterRequestDto registerRequestDto) {
    // generate the password
    final CreatePilotRequestDto createPilotRequestDto = CreatePilotRequestDto.builder()
        .username(registerRequestDto.getUsername())
        .password(encryptPassword(registerRequestDto.getPassword()))
        .build();

    pilotService.save(createPilotRequestDto);
  }

  private String encryptPassword(String password) {
    return Arrays.toString(Base64.getEncoder().encode(password.getBytes(StandardCharsets.UTF_8)));
  }
}
