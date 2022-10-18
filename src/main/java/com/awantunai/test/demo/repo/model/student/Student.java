package com.awantunai.test.demo.repo.model.student;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name="userId")
    Long userid;
    @Column(name="name")
    String name;
    @Column(name="parentName")
    String parentName;
    @Column(name="age")
    String age;
    @Column(name="birthPlace")
    String birthPlace;

}
