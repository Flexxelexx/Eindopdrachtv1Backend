package com.example.eindopdrachtbackendv1.Controllers;

import com.example.eindopdrachtbackendv1.DTOS.UserDTO;
import com.example.eindopdrachtbackendv1.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class UserController {
//    @Autowired

    private final UserService service;

    public UserController (UserService service) {
        this.service = service;
    }

    @PostMapping("/account")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        String userName = service.createUser(userDTO);
        String lastName = service.createUser(userDTO);
        String profileName = service.createUser(userDTO);
        String passWord = service.createUser(userDTO);
        String apiKey = service.createUser(userDTO);
        String email = service.createUser(userDTO);
        LocalDate dob = service.createUser(userDTO);
        return new ResponseEntity<>(userName + lastName + profileName + passWord + apiKey + email + dob, HttpStatus.CREATED);
    }
}
