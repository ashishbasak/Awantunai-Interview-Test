package com.awantunai.test.demo.services.impl;

import com.awantunai.test.demo.dto.mapper.ModelMapper;
import com.awantunai.test.demo.dto.request.StudentUserRegisterRequest;
import com.awantunai.test.demo.repo.model.student.StudentDao;
import com.awantunai.test.demo.repo.model.userStudent.StudentUserDao;
import com.awantunai.test.demo.services.StudentAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentImpl implements StudentAccount {

    private final StudentDao studentDao;
    private final StudentUserDao studentUserDao;
    private final ModelMapper modelMapper;

    @Autowired
    public StudentImpl(StudentDao studentDao, StudentUserDao studentUserDao, ModelMapper modelMapper) {
        this.studentDao = studentDao;
        this.studentUserDao = studentUserDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(StudentUserRegisterRequest studentUserRegisterRequest) {

    }

    @Override
    public void registerDetail(StudentUserRegisterRequest studentUserRegisterRequest) {

    }

    @Override
    public void validateUser(String username, String password) {

    }
}
