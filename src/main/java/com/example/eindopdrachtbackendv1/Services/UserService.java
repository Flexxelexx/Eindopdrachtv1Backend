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

    public UserDTO getUser (Long id) {
        UserDTO dto = new UserDTO();
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            dto = UserDTO.fromUser(user.get());
        } else {
            throw new UsernameNotFoundException(id.toString());
        }
        return dto;
    }

    public boolean userExists(Long id) {
        return userRepository.existsById(id);
    }

    public String createUser (UserDTO userDTO) {
        User newUser = userRepository.save(UserDTO.toUser(userDTO));
        return newUser.getProfilename();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    public void updateProfilename( Long id, UserDTO newUser) {
        if (!userExists(id)) throw new RecordNotFoundException();
        User user = userRepository.findById(id).get();
        user.setProfilename(newUser.getProfilename());
        userRepository.save(user);
    }

    public void updatePassword( Long id, UserDTO newUser) {
        if (!userExists(id)) throw new RecordNotFoundException();
        User user = userRepository.findById(id).get();
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }

    public void updateEmail( Long id, UserDTO newUser) {
        if (!userExists(id)) throw new RecordNotFoundException();
        User user = userRepository.findById(id).get();
        user.setEmail(newUser.getEmail());
        userRepository.save(user);
    }

    public void updateDob( Long id, UserDTO newUser) {
        if (!userExists(id)) throw new RecordNotFoundException();
        User user = userRepository.findById(id).get();
        user.setDob(newUser.getDob());
        userRepository.save(user);
    }

    // meerdere if statements maken voor elke ding

}
