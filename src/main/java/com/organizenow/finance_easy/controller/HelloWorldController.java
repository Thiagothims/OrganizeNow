package com.organizenow.finance_easy.controller;

import com.organizenow.finance_easy.domain.User;
import com.organizenow.finance_easy.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloService;

    @GetMapping
    public ResponseEntity<String> hello() {
        String name = "Thiago";

        String response = helloService.getHello(name);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> messageWelcome(@RequestBody User body) {
        String messageWelcome = "Welcome " + body.getFirstName() + " " + body.getLastName() + "!";

        return new ResponseEntity(messageWelcome, HttpStatus.OK);
    }

}
