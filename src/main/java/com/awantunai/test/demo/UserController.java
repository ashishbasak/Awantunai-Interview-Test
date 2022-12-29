package com.awantunai.test.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path="/signup")
    public String createNewUser(@RequestBody User newUser) {
        try {
            userService.createNewUser(newUser);
            return "Successfully create new user";
        } catch (UsedUsernameException ex) {
            return "Username already existed";
        }
    }

    @PostMapping(path="/signin")
    public String loginUser(@RequestBody User postUser) {
        if (userService.findUser(postUser) != null) {
            return "Successfully login";
        }

        return "Invalid username or password";
    }
}
