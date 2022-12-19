package com.awantunai.test.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthcheckController {
    @GetMapping("/healthcheck")
    public String healthCheck() {
        return "Service is up";
    }
}
