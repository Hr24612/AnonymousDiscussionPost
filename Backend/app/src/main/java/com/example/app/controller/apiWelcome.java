package com.example.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Welcome class
 */

@RequestMapping("/api")
@RestController
public class apiWelcome {

    //Welcome message
    @GetMapping
    public String welcome() {
        return "Welcome to Anti Social Social App API";
    }
}
