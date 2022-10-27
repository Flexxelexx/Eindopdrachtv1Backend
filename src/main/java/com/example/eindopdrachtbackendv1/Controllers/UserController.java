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
    public ResponseEntity<UserDTO> getUser(@PathVariable("username") Long id) {

        UserDTO optionalUser = userService.getUser(id);

        return ResponseEntity.ok().body(optionalUser);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO id) {
        String newUsername = userService.createUser(id);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{id}/updatename")
    public ResponseEntity<UserDTO> updateUsername(@PathVariable("username") Long id, @RequestBody UserDTO dto) {

        userService.updateUsername(id, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}/updatepassword")
    public ResponseEntity<UserDTO> updatePassword(@PathVariable("username") Long id, @RequestBody UserDTO dto) {

        userService.updatePassword(id, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}/updateemail")
    public ResponseEntity<UserDTO> updateEmail(@PathVariable("username") Long id, @RequestBody UserDTO dto) {

        userService.updateEmail(id, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}/updatedob")
    public ResponseEntity<UserDTO> updateDob(@PathVariable("username") Long id, @RequestBody UserDTO dto) {

        userService.updateDob(id, dto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("username") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
