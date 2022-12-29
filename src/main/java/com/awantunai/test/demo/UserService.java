package com.awantunai.test.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired(required=false)
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createNewUser(User newUser) {

        List<User> existingUsers = (List<User>) userRepository.findAll();

        for (User user : existingUsers) {
            if (user.getUsername().equals(newUser.getUsername())) {
                throw new UsedUsernameException(user.getId());
            }
        }

        return userRepository.save(newUser);
    }

    public User findUser(User postUser) {
        List<User> existingUsers = (List<User>) userRepository.findAll();

        for (User user : existingUsers) {
            if (user.getUsername().equals(postUser.getUsername()) && user.getPassword().equals(postUser.getPassword())) {
                return user;
            }
        }
        return null;
    }

}
