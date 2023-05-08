package com.demo.spring.web.controller;

import com.demo.spring.service.StudentService;
import com.demo.spring.web.model.request.RegisterRequest;
import com.demo.spring.web.model.response.RegisterResponse;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping()
  public Mono<List<RegisterResponse>> getAllStudents() {
    return studentService.getAll();
  }

  @PostMapping(value = "register", consumes = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Boolean> register(@RequestBody RegisterRequest registerRequest) {
    return studentService.register(registerRequest);
  }
}
