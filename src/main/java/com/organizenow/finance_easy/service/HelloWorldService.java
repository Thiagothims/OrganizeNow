package com.organizenow.finance_easy.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    public String getHello(String name) {
        String message = "Hello World " + name + "!";

        return message;
    }
}