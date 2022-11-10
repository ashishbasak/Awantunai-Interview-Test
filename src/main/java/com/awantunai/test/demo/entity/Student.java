package com.awantunai.test.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

    @Id
    private int id;

    private String firstName;

    private String lastName;

    private String emailID;

    private String password;

    private int age;
}
