package com.awantunai.test.demo.repo.model.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDao {
    private final StudentRepo studentRepo;

    @Autowired
    public StudentDao(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void addStudent(Student student){
        this.studentRepo.save(student);

    }

    public void updateStudent(){

    }

    public Student findStudent(Long id){
        return this.studentRepo.getOne(id);
    }

    public void deleteStudent(Long id){
        Student student = this.findStudent(id);

        this.studentRepo.delete(student);
    }

    public List<Student> findAllStudent(){
        return this.studentRepo.findAll();

    }

//    public Page<Student> findStudent(){
//        Pageable pageable =
//        this.studentRepo.findAll()
//    }
}
