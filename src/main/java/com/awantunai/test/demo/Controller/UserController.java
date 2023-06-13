package com.awantunai.test.demo.Controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.awantunai.test.demo.Constant.Constant;
import com.awantunai.test.demo.Dto.UserDTO;
import com.awantunai.test.demo.Service.UserService;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/user")
    public ResponseEntity<String> signup(HttpServletRequest request, @RequestBody UserDTO user) {
        return userService.Signup(user);
    }

    @GetMapping(value = "/user")
    public ResponseEntity<Object> login(HttpServletRequest request, @RequestHeader("name") String name, @RequestHeader("password") String password) {
        return userService.Login(name, password);
    }

    @GetMapping(value = "/all-user")
    public ResponseEntity<Object> getAllUser(HttpServletRequest request) {
        return ResponseEntity.status(200).body(Constant.USERS);
    }
    
}
