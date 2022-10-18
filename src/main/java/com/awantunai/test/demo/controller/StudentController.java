package com.awantunai.test.demo.controller;

import com.awantunai.test.demo.repo.model.Student;
import com.awantunai.test.demo.repo.model.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
@ControllerAdvice
public class StudentController {

    private final StudentDao studentDao;

    @Autowired
    public StudentController(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @GetMapping("{id}")
    public Student findStudent(@PathVariable("id") String id){
        return this.studentDao.findStudent(Long.parseLong(id));
    }

    @GetMapping
    public List<Student> findStudent(){
        return this.studentDao.findAllStudent();
    }

    @PostMapping
    public void saveStudent(@RequestBody Student student){
        this.studentDao.addStudent(student);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable("id") String id){
        this.studentDao.deleteStudent(Long.parseLong(id));
    }
}
