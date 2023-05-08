package com.demo.spring.web.model.request;

import com.demo.spring.common.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {

  private String address;

  private String email;

  private Gender gender;

  private String password;

  private String username;
}
