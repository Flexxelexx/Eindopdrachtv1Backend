package com.example.eindopdrachtbackendv1.controller;

import com.example.eindopdrachtbackendv1.dto.FishingSpotDTO;
import com.example.eindopdrachtbackendv1.dto.UserDTO;
import com.example.eindopdrachtbackendv1.Services.UserService;
import com.example.eindopdrachtbackendv1.dto.input.UserInputDto;
import com.example.eindopdrachtbackendv1.dto.output.UserOutputDto;
import com.example.eindopdrachtbackendv1.models.Role;
import com.example.eindopdrachtbackendv1.models.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserOutputDto>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }
    @GetMapping("/id")
    public ResponseEntity<UserOutputDto> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserOutputDto> createUser(@Valid @RequestBody UserInputDto inputUser) {

        UserOutputDto user = userService.createUser(inputUser);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(user).toUri();

        return ResponseEntity.created(uri).body(user);
    }

    @PostMapping
    public ResponseEntity<UserOutputDto> updateUser(@Valid @RequestBody UserInputDto userInput) {

        UserOutputDto user = userService.updateUser(userInput);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(user).toUri();

        return ResponseEntity.created(uri).body(user);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

//    @PutMapping(value = "/{id}")
//    public void addFishSpotToUser(@PathVariable Long id, @RequestBody FishingSpotDTO fishingSpotDTO){
//        userService.addFishSpotToUser(id, fishingSpotDTO);
//    }


}
