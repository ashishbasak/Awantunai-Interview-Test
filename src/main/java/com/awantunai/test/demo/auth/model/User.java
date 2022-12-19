package com.awantunai.test.demo.auth.model;

import java.util.UUID;

public class User {
    private UUID id;
    private String email;
    private String password;
    private String name;
    private String address;
    private Integer age;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Integer getAge() {
        return age;
    }

    public User(UUID id, String email, String password, String name, String address, Integer age) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }
}
