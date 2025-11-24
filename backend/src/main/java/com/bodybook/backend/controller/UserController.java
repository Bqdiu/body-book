package com.bodybook.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public Message hello() {
        return new Message("Hello");
    }
    record Message(String message) {}
}