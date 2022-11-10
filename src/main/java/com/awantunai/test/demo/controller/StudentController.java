package com.awantunai.test.demo.controller;

import com.awantunai.test.demo.entity.Student;
import com.awantunai.test.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUpStudent(@RequestBody Student student){

        try{
            studentService.signUpStudent(student);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Student Added to Database", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginStudent(@RequestBody Student student){

        try{
            studentService.loginStudent(student);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Authentication Successful", HttpStatus.OK);

    }

}
