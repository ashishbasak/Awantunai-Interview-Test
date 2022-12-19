package com.awantunai.test.demo.auth.repository;

import com.awantunai.test.demo.auth.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private List<User> userStorage = new ArrayList<>();

    public void storeUser(User user) {
        userStorage.add(user);
    }

    public User getUserByEmail(String email) {
        for (User user: userStorage) {
            if (user.getEmail() == email) {
                return user;
            }
        }

        return null;
    }
}
