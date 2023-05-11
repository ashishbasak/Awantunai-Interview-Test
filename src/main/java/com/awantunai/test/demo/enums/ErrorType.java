package com.awantunai.test.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorType {

  PILOT_NOT_FOUND("Pilot with this id: %d is not found", "0001");

  private final String message;
  private final String code;
}
