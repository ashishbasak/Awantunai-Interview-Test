package com.demo.spring.service.impl;

import com.demo.spring.entity.Student;
import com.demo.spring.repository.StudentRepository;
import com.demo.spring.service.AuthService;
import java.util.UUID;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuthServiceImpl implements AuthService {

  private final PasswordEncoder passwordEncoder;

  private final StudentRepository studentRepository;

  public AuthServiceImpl(PasswordEncoder passwordEncoder, StudentRepository studentRepository) {
    this.passwordEncoder = passwordEncoder;
    this.studentRepository = studentRepository;
  }

  @Override
  public Mono<String> signIn(String username, String password) {
    return studentRepository.findByUsername(username)
        .filter(student -> passwordEncoder.matches(password, student.getPassword()))
        .map(this::generateToken)
        .switchIfEmpty(Mono.error(new Exception("Student not found")));
  }

  private String generateToken(Student student) {
    return UUID.randomUUID()
        .toString();
  }
}
