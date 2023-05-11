package com.awantunai.test.demo.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Airplane {

  @Id
  private Integer id;

  private String name;

  @OneToMany(mappedBy = "airplane")
  private List<Pilot> pilots;
}
