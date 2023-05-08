package com.demo.spring.service;

import reactor.core.publisher.Mono;

public interface AuthService {

  Mono<String> signIn(String username, String password);
}
