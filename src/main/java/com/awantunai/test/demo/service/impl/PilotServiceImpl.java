package com.awantunai.test.demo.service.impl;

import com.awantunai.test.demo.dto.PilotDto;
import com.awantunai.test.demo.dto.RegisterRequestDto;
import com.awantunai.test.demo.entity.Pilot;
import com.awantunai.test.demo.enums.ErrorType;
import com.awantunai.test.demo.exception.ClientException;
import com.awantunai.test.demo.repository.PilotRepository;
import com.awantunai.test.demo.service.PilotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PilotServiceImpl implements PilotService {

  private final PilotRepository pilotRepository;

  @Override
  public boolean isExistByUsername(String username) {
    return pilotRepository.existsByUsernameAndDeletedAtIsNull(username);
  }

  @Override
  public PilotDto getById(Integer pilotId) {
    final Pilot pilot = pilotRepository.findByIdAndDeletedAtIsNull(pilotId).orElseThrow(() -> {
      MDC.clear();
      MDC.put("pilot_id", String.valueOf(pilotId));
      log.error("Pilot Id is not found with the id is: {}", pilotId);
      throw new ClientException(ErrorType.PILOT_NOT_FOUND.getMessage(),
          ErrorType.PILOT_NOT_FOUND.getCode());
    });


  }

  @Override
  public PilotDto save(RegisterRequestDto requestDto) {
    final int airplaneId = requestDto.getAirplaneId() == null || requestDto.getAirplaneId() < 0 ? 0
        : requestDto.getAirplaneId();
    requestDto.setAirplaneId(airplaneId);

    final Pilot pilot = new Pilot();
    BeanUtils.copyProperties(requestDto, pilot);

    final Pilot savedPilot = pilotRepository.save(pilot);

    final PilotDto pilotDto = new PilotDto();
    BeanUtils.copyProperties(savedPilot, pilotDto);

    return pilotDto;
  }
}
