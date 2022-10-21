package com.example.eindopdrachtbackendv1.Controllers;

import com.example.eindopdrachtbackendv1.DTOS.UserDTO;
import com.example.eindopdrachtbackendv1.Services.UserService;
import com.example.eindopdrachtbackendv1.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
//    @Autowired

    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public ResponseEntity<List<UserDTO>> getUsers() {

        List<UserDTO> userDtos = userService.getUsers();

        return ResponseEntity.ok().body(userDtos);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("username") String username) {

        UserDTO optionalUser = userService.getUser(username);

        return ResponseEntity.ok().body(optionalUser);
    }

    @PostMapping("/account")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO dto) {

        String newUsername = userService.createUser(dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();

        return ResponseEntity.created(location).build();
    }
}
