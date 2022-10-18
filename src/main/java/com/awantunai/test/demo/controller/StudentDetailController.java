package com.awantunai.test.demo.controller;

import com.awantunai.test.demo.dto.mapper.ModelMapper;
import com.awantunai.test.demo.dto.request.StudentDetailRegisterRequest;
import com.awantunai.test.demo.repo.model.student.Student;
import com.awantunai.test.demo.repo.model.student.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentDetailController {

    private final StudentDao studentDao;
    private final ModelMapper modelMapper;

    @Autowired
    public StudentDetailController(StudentDao studentDao, ModelMapper modelMapper) {
        this.studentDao = studentDao;
        this.modelMapper = modelMapper;
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
    public void saveStudent(@RequestBody StudentDetailRegisterRequest student){
        this.studentDao.addStudent(modelMapper.map().map(student, Student.class));
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable("id") String id){
        this.studentDao.deleteStudent(Long.parseLong(id));
    }
}
