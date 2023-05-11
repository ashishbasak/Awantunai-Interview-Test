package com.awantunai.test.demo.entity;

import java.time.ZonedDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Pilot {

  @Id
  private Integer id;

  private String name;
  private String username;
  private String password;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "airplane_id", nullable = false)
  private Airplane airplane;

  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;
  private ZonedDateTime deletedAt;
}
