package com.organizenow.finance_easy.presentation.controller.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.organizenow.finance_easy.application.service.users.UserService;
import com.organizenow.finance_easy.domain.dto.request.UserRegistrationRequestDTO;
import com.organizenow.finance_easy.domain.dto.response.UserRegistrationResponseDTO;
import com.organizenow.finance_easy.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ObjectMapper mapper;

    @PostMapping("/registration")
    public ResponseEntity<String> registerNewUser(@RequestBody UserRegistrationRequestDTO newUser) {
        try {
            UserRegistrationResponseDTO registeredUser = userService.registerNewUser(newUser);

            return new ResponseEntity<>(mapper.writeValueAsString(registeredUser), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("{\"error\":\"" + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
    }

}
