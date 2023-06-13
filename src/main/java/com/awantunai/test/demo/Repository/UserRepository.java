package com.awantunai.test.demo.Repository;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.awantunai.test.demo.Constant.Constant;
import com.awantunai.test.demo.Entity.UserEntity;
import com.awantunai.test.demo.Util.Util;

@Repository
public class UserRepository {
    public void SignupUser(UserEntity user) {
        Constant.USERS.add(user);
    }

    public Optional<UserEntity> Login(String name, String password) {
        return Constant.USERS.stream().filter(u -> u.getName().equals(name) && u.getPassword().equals(Util.encodeSHA256(password))).findFirst();
    }
}
