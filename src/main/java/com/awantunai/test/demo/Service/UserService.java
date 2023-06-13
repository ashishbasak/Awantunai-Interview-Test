package com.awantunai.test.demo.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.awantunai.test.demo.Dto.UserDTO;
import com.awantunai.test.demo.Entity.UserEntity;
import com.awantunai.test.demo.Repository.UserRepository;
import com.awantunai.test.demo.Util.Util;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ResponseEntity<String> Signup(UserDTO newUser) {
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setName(newUser.getName());
            userEntity.setYear(newUser.getYear());
            userEntity.setAddress(newUser.getAddress());
        
            userEntity.setPassword(Util.encodeSHA256(newUser.getPassword()));
            userRepository.SignupUser(userEntity);

            return ResponseEntity.status(201).body("Success Signup");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed Signup");
        }
    }

    public ResponseEntity<Object> Login(String name, String password) {
        try {
            Optional<UserEntity> user = userRepository.Login(name, password);
            if (user.isPresent()) {
                UserEntity userEntity = user.get();
                UserDTO userDTO = new UserDTO();

                userDTO.setName(userEntity.getName());
                userDTO.setYear(userEntity.getYear());
                userDTO.setAddress(userEntity.getAddress());
                return ResponseEntity.ok().body(userDTO);
            }

            return ResponseEntity.status(404).body("user not found");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Unhandled Error");
        }
    }
}
