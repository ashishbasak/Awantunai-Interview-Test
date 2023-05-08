package com.demo.spring.repository;

import com.demo.spring.entity.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface StudentRepository extends ReactiveCrudRepository<Student, Integer> {

  Mono<Student> findByUsername(String username);
}
