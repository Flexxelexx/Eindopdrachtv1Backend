package com.example.eindopdrachtbackendv1.Services;

import com.example.eindopdrachtbackendv1.DTOS.UserDTO;
import com.example.eindopdrachtbackendv1.Exceptions.RecordNotFoundException;
import com.example.eindopdrachtbackendv1.Repositories.UserRepository;
import com.example.eindopdrachtbackendv1.Utils.RandomStringGenerator;
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

    public UserDTO getUser (String profileName) {
        UserDTO dto = new UserDTO();
        Optional<User> user = userRepository.findById(profileName);
        if (user.isPresent()) {
            dto = UserDTO.fromUser(user.get());
        } else {
            throw new UsernameNotFoundException(profileName);
        }
        return dto;
    }

    public boolean userExists(String profileName) {
        return userRepository.existsById(profileName);
    }

    public String createUser (UserDTO userDTO) {
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        userDTO.setApikey(randomString);
        User newUser = userRepository.save(UserDTO.toUser(userDTO));
        return newUser.getProfilename();
    }

    public void deleteUser(String profileName) {
        userRepository.deleteById(profileName);
    }

    public void updateUser( String profileName, UserDTO newUser) {
        if (!userRepository.existsById(profileName)) throw new RecordNotFoundException();
        User user = userRepository.findById(profileName).get();
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }

}
