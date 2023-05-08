package com.demo.spring.web.model.response;

import com.demo.spring.common.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterResponse {

  private String address;

  private String email;

  private Gender gender;

  private String username;
}
