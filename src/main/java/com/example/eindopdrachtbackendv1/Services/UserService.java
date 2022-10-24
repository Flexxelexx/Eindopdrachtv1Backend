package com.example.eindopdrachtbackendv1.Services;

import com.example.eindopdrachtbackendv1.DTOS.UserDTO;
import com.example.eindopdrachtbackendv1.Exceptions.RecordNotFoundException;
import com.example.eindopdrachtbackendv1.Repositories.UserRepository;
import com.example.eindopdrachtbackendv1.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getUsers() {
        List <UserDTO> collection = new ArrayList<>();
        List <User> list = userRepository.findAll();
        for (User user : list) {
            collection.add(UserDTO.fromUser(user));
        }

        return collection;
    }

    public UserDTO getUser (String username) {
        UserDTO dto = new UserDTO();
        Optional<User> user = userRepository.findById(username);
        if (user.isPresent()) {
            dto = UserDTO.fromUser(user.get());
        } else {
            throw new UsernameNotFoundException(username);
        }
        return dto;
    }

    public boolean userExists(String username) {
        return userRepository.existsById(username);
    }

    public String createUser (UserDTO userDTO) {
        User newUser = userRepository.save(UserDTO.toUser(userDTO));
        return newUser.getProfilename();
    }

    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    public void updateName( String fname, UserDTO newUser) {
        if (!userExists(fname)) throw new RecordNotFoundException();
        User user = userRepository.findById(fname).get();
        user.setName(newUser.getName());
        userRepository.save(user);
    }

    public void updateLastname( String lastName, UserDTO newUser) {
        if (!userExists(lastName)) throw new RecordNotFoundException();
        User user = userRepository.findById(lastName).get();
        user.setLastname(newUser.getLastname());
        userRepository.save(user);
    }

    public void updateProfilename( String profileName, UserDTO newUser) {
        if (!userExists(profileName)) throw new RecordNotFoundException();
        User user = userRepository.findById(profileName).get();
        user.setProfilename(newUser.getProfilename());
        userRepository.save(user);
    }

    public void updatePassword( String password, UserDTO newUser) {
        if (!userExists(password)) throw new RecordNotFoundException();
        User user = userRepository.findById(password).get();
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }

    public void updateEmail( String email, UserDTO newUser) {
        if (!userExists(email)) throw new RecordNotFoundException();
        User user = userRepository.findById(email).get();
        user.setEmail(newUser.getEmail());
        userRepository.save(user);
    }

    public void updateDob( String dob, UserDTO newUser) {
        if (!userExists(dob)) throw new RecordNotFoundException();
        User user = userRepository.findById(dob).get();
        user.setDob(newUser.getDob());
        userRepository.save(user);
    }

    // meerdere if statements maken voor elke ding

}
