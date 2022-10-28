package com.example.eindopdrachtbackendv1.Controllers;

import com.example.eindopdrachtbackendv1.DTOS.UserDTO;
import com.example.eindopdrachtbackendv1.Repositories.RoleRepository;
import com.example.eindopdrachtbackendv1.Repositories.UserRepository;
import com.example.eindopdrachtbackendv1.Services.UserService;
import com.example.eindopdrachtbackendv1.models.Role;
import com.example.eindopdrachtbackendv1.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder encoder;

    public UserController(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

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
    public String createUser(@RequestBody UserDTO userDTO) {
            User newUser = new User();
            newUser.setUsername(userDTO.username);
            newUser.setPassword(encoder.encode(userDTO.password));
            newUser.setEmail(userDTO.email);
            newUser.setDob(userDTO.dob);

            List<Role> userRoles = new ArrayList<>();
            for (String rolename : userDTO.roles) {
                Optional<Role> or = roleRepository.findById(rolename);

                userRoles.add(or.get());
            }
            newUser.setRoles(userRoles);

            userRepository.save(newUser);

            return "Done";
        }


    @PutMapping(value = "/{id}/updatename")
    public ResponseEntity<UserDTO> updateUsername(@PathVariable("id") Long id, @RequestBody UserDTO dto) {

        userService.updateUsername(id, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}/updatepassword")
    public ResponseEntity<UserDTO> updatePassword(@PathVariable("id") Long id, @RequestBody UserDTO dto) {

        dto.setPassword(encoder.encode(dto.password));
        userService.updatePassword(id, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}/updateemail")
    public ResponseEntity<UserDTO> updateEmail(@PathVariable("id") Long id, @RequestBody UserDTO dto) {

        userService.updateEmail(id, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}/updatedob")
    public ResponseEntity<UserDTO> updateDob(@PathVariable("id") Long id, @RequestBody UserDTO dto) {

        userService.updateDob(id, dto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


}
