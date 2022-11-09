package com.awantunai.test.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private Long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;
}
