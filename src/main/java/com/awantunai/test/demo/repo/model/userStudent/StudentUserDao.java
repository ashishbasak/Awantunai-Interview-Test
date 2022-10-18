package com.awantunai.test.demo.repo.model.userStudent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentUserDao {
    private final StudentUserRepo studentRepo;

    @Autowired
    public StudentUserDao(StudentUserRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void addStudentUser(StudentUser student){
        this.studentRepo.save(student);

    }

    public StudentUser findStudent(String username, String password){
        return this.studentRepo.findByUsernameAndPassword(username, password).orElse(null);
    }
}
