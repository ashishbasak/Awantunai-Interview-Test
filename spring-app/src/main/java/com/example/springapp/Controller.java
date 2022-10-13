package com.example.springapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @GetMapping("/")
    public String index(){
        return "Helloo gradle!";
    }

    @RequestMapping(value = "/Test", method = {RequestMethod.GET})
    public String index2(String name){
        return "Helloo " + name;
    }
}
