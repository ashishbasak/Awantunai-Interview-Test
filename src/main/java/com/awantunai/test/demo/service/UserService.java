package com.awantunai.test.demo.service;

import com.awantunai.test.demo.entity.User;
import com.awantunai.test.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public boolean verify(String identityCard, String password) {
    User user = userRepository.findUserByIdentityCard(identityCard).orElse(null);

    return user != null && password.equals(user.getPassword());
  }
}
