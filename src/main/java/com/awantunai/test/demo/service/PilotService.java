package com.awantunai.test.demo.service;

import com.awantunai.test.demo.dto.CreatePilotRequestDto;
import com.awantunai.test.demo.dto.PilotDto;

public interface PilotService {

  // login
  boolean isExistByUsername(String username);

  PilotDto getById(Integer pilotId);

  PilotDto save(CreatePilotRequestDto pilotRequestDto);
}
