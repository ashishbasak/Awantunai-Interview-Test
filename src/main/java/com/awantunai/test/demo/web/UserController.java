package com.awantunai.test.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public String test(){
        return "Hello";
    }

    @PostMapping("/registration")
    public String registratrion(){
        return "registration";
    }

    @PostMapping("/login")
    public String login(){
        return "login";
    }
}
