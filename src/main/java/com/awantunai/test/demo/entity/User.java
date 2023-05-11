package com.awantunai.test.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "user")
public class User {
  @Id
  private Long id;
  private String identityCard;
  private String name;
  private String password;
}
