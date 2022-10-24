package com.example.eindopdrachtbackendv1.Controllers;

import com.example.eindopdrachtbackendv1.DTOS.UserDTO;
import com.example.eindopdrachtbackendv1.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

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

    @PostMapping("")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO dto) {

        String newUsername = userService.createUser(dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<UserDTO> updateName(@PathVariable("username") String fname, @RequestBody UserDTO dto) {

        userService.updateName(fname, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<UserDTO> updateLastname(@PathVariable("username") String lastName, @RequestBody UserDTO dto) {

        userService.updateLastname(lastName, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<UserDTO> updateProfilename(@PathVariable("username") String profileName, @RequestBody UserDTO dto) {

        userService.updateProfilename(profileName, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<UserDTO> updatePassword(@PathVariable("username") String password, @RequestBody UserDTO dto) {

        userService.updatePassword(password, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<UserDTO> updateEmail(@PathVariable("username") String email, @RequestBody UserDTO dto) {

        userService.updateEmail(email, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<UserDTO> updateDob(@PathVariable("username") String dob, @RequestBody UserDTO dto) {

        userService.updateDob(dob, dto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }
}
