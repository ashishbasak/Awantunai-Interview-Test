package com.awantunai.test.demo.dto.request;

import lombok.Data;

import javax.persistence.Column;

@Data
public class StudentDetailRegisterRequest {
    private String name;
    private String parentName;
    private String age;
    private String birthPlace;
}
