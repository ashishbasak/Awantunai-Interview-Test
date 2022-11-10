package com.awantunai.test.demo.service;

import com.awantunai.test.demo.entity.Student;
import com.awantunai.test.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void signUpStudent(Student student) throws Exception {

        Optional<Student> studentInDatabase =  studentRepository.findById(student.getId());

        if(studentInDatabase.isPresent()){
            throw new Exception("Student Already Present in Database");
        }

        String encryptedPassword = encodeEncryptUserPassword(student.getPassword());

        student.setPassword(encryptedPassword);

        studentRepository.save(student);
    }

    public void loginStudent(Student student) throws Exception {

        Optional<Student> studentInDatabase =  studentRepository.findById(student.getId());

        if(!studentInDatabase.get().getEmailID().equals(student.getEmailID())
                && !studentInDatabase.get().getPassword().equals(student.getPassword())) {

            throw new Exception("EmailID Or Password Incorrect, Please try again");
        }
    }

    private String encodeEncryptUserPassword(String password)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

}
