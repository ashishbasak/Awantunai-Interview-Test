package com.demo.spring.service.impl;

import com.demo.spring.entity.Student;
import com.demo.spring.repository.StudentRepository;
import com.demo.spring.service.StudentService;
import com.demo.spring.web.model.request.RegisterRequest;
import com.demo.spring.web.model.response.RegisterResponse;
import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentService {

  private final PasswordEncoder passwordEncoder;

  private final StudentRepository studentRepository;

  public StudentServiceImpl(PasswordEncoder passwordEncoder, StudentRepository studentRepository) {
    this.passwordEncoder = passwordEncoder;
    this.studentRepository = studentRepository;
  }

  @Override
  public Mono<List<RegisterResponse>> getAll() {
    return studentRepository.findAll()
        .map(this::toWebResponse)
        .collectList();
  }

  @Override
  public Mono<Boolean> register(RegisterRequest registerRequest) {
    return Mono.just(creteStudent(registerRequest))
        .flatMap(studentRepository::save)
        .thenReturn(Boolean.TRUE);
  }

  private Student creteStudent(RegisterRequest registerRequest) {
    return Student.builder()
        .address(registerRequest.getAddress())
        .email(registerRequest.getEmail())
        .gender(registerRequest.getGender())
        .username(registerRequest.getUsername())
        .password(passwordEncoder.encode(registerRequest.getPassword()))
        .build();
  }

  private RegisterResponse toWebResponse(Student student) {
    return RegisterResponse.builder()
        .address(student.getAddress())
        .email(student.getEmail())
        .gender(student.getGender())
        .username(student.getUsername())
        .build();
  }
}
