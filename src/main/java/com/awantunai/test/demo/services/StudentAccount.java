package com.awantunai.test.demo.services;

import com.awantunai.test.demo.dto.request.StudentDetailRegisterRequest;
import com.awantunai.test.demo.dto.request.StudentUserRegisterRequest;

public interface StudentAccount {
    void registerUser(StudentUserRegisterRequest studentUserRegisterRequest);
    void registerDetail(StudentUserRegisterRequest studentUserRegisterRequest);
    void validateUser(String username, String password);
}
