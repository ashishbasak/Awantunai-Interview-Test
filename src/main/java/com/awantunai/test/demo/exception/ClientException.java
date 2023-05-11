package com.awantunai.test.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientException extends RuntimeException {

  private String message;
  private String code;
}
