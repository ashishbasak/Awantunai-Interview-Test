package com.awantunai.test.demo.controller;

import com.awantunai.test.demo.dto.exception.ExistUserException;
import com.awantunai.test.demo.dto.exception.InvalidUserPasswordException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CotrollerAdvisor {
    @ExceptionHandler({ExistUserException.class, InvalidUserPasswordException.class})
    public void badrequstException(Exception e){

    }

    @ExceptionHandler
    public void generalException(Exception e){

    }
}
