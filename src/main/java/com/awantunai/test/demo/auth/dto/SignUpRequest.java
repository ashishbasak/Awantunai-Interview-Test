package com.awantunai.test.demo.auth.dto;

import com.awantunai.test.demo.auth.model.User;

import java.util.UUID;

public class SignUpRequest extends User {
    private String email;
    private String password;
    private String name;
    private String address;
    private int age;
    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public int getAge() {
        return age;
    }


    public SignUpRequest(UUID id, String email, String password, String name, String address, int age, String email1, String password1, String name1, String address1, int age1) {
        super(id, email, password, name, address, age);
        this.email = email1;
        this.password = password1;
        this.name = name1;
        this.address = address1;
        this.age = age1;
    }

}
