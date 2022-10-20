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
            collection.add(fromUser(user));
        }

        return collection;
    }

    public UserDTO getUser (String profileName) {
        UserDTO dto = new UserDTO();
        Optional<User> user = userRepository.findById(profileName);
        if (user.isPresent()) {
            dto = fromUser(user.get());
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
        User newUser = userRepository.save(toUser(userDTO));
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

    public void uploadCaughtFish() {

    }

    public static UserDTO fromUser(User user) {

        UserDTO dto = new UserDTO();

        dto.name = user.getName();
        dto.lastname = user.getLastname();
        dto.profilename = user.getProfilename();
        dto.password = user.getPassword();
        dto.apikey = user.getApikey();
        dto.email = user.getEmail();
        dto.dob = user.getDob();

        return dto;
    }

    public User toUser(UserDTO userDTO) {

        var user = new User();

        user.setName(userDTO.getName());
        user.setLastname(userDTO.getLastname());
        user.setProfilename(userDTO.getProfilename());
        user.setPassword(userDTO.getPassword());
        user.setApikey(userDTO.getApikey());
        user.setEmail(userDTO.getEmail());
        user.setDob(userDTO.getDob());

        return user;
    }
}
