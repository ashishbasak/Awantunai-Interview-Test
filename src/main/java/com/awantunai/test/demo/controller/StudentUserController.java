package com.awantunai.test.demo.controller;

import com.awantunai.test.demo.dto.request.StudentDetailRegisterRequest;
import com.awantunai.test.demo.dto.request.StudentUserRegisterRequest;
import com.awantunai.test.demo.services.StudentAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentUserController {
    private final StudentAccount studentAccount;

    @Autowired
    public StudentUserController(StudentAccount studentAccount) {
        this.studentAccount = studentAccount;
    }

    @PostMapping("register/detail")
    public void register(@RequestBody StudentDetailRegisterRequest request){

    }

    @PostMapping("register")
    public void register(@RequestBody StudentUserRegisterRequest request){

    }

    @PostMapping("validate")
    public void validate(@RequestBody StudentAccount request){

    }
}
