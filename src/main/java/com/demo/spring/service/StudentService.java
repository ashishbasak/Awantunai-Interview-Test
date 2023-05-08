package com.demo.spring.service;

import com.demo.spring.web.model.request.RegisterRequest;
import com.demo.spring.web.model.response.RegisterResponse;
import java.util.List;
import reactor.core.publisher.Mono;

public interface StudentService {

  Mono<List<RegisterResponse>> getAll();

  Mono<Boolean> register(RegisterRequest registerRequest);
}
