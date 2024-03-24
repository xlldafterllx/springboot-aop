package com.rops.curso.springboot.app.aop.springbootaop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/app")
public class GreetingController {

    @GetMapping("/gretting")
    public ResponseEntity<?> gretting() {
        return ResponseEntity.ok(Collections.singletonMap("gretting", null));
    }    
}