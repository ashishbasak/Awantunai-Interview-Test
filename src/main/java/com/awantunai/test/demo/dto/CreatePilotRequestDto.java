package com.awantunai.test.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePilotRequestDto {

  private String name;
  private String username;
  private String password;
  private Integer airplaneId;
}
