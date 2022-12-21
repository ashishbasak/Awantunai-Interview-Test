package com.awantunai.test.demo.controller;


import com.awantunai.test.demo.dto.AuthenticateRequestBody;
import com.awantunai.test.demo.service.AuthenticateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    AuthenticateUser authenticateUser;

    @PostMapping(value = "/login")
    public ResponseEntity authenticateUser(@RequestBody AuthenticateRequestBody authenticateRequestBody){
        String response = authenticateUser.authenticateUser(authenticateRequestBody);
        return ResponseEntity.ok().body(response);
    }


    @GetMapping(value = "/user")
    public ResponseEntity addUserToHashMap(){
        authenticateUser.addUserToHashMap();
        return ResponseEntity.ok().body("Add User");
    }
}
