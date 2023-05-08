package com.demo.spring.entity;

import com.demo.spring.common.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "tbl_students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

  private String address;

  private String email;

  private Gender gender;

  @Id
  private Integer id;

  private String password;

  private String token;

  private String username;
}
