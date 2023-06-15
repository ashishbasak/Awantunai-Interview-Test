package com.awantunai.test.demo.service;

import com.awantunai.test.demo.exception.NotFoundException;
import com.awantunai.test.demo.exception.WrongCredentialsException;
import com.awantunai.test.demo.model.User;
import com.awantunai.test.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getLogin(String name, String password) {
        Optional<User> optionalUser;
            if(name.contains("@")) {
                optionalUser = userRepository.findByEmail(name);
            }else {
                optionalUser = userRepository.findByUsername(name);
            }

            User user = optionalUser.orElseThrow(() -> new NotFoundException("User not found"));

            if(!user.getPassword().equalsIgnoreCase(password) )
                throw new WrongCredentialsException("Wrong Username or Password");

            user.setLogin(true);

            user = userRepository.save(user);

            return user;

    }
}
