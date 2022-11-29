package com.example.eindopdrachtbackendv1.Services;

import com.example.eindopdrachtbackendv1.DTOS.FishingSpotDTO;
import com.example.eindopdrachtbackendv1.DTOS.UserDTO;
import com.example.eindopdrachtbackendv1.Exceptions.RecordNotFoundException;
import com.example.eindopdrachtbackendv1.Repositories.UserRepository;
import com.example.eindopdrachtbackendv1.models.FishingSpot;
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

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getUsers() {
        List<UserDTO> collection = new ArrayList<>();
        List<User> list = userRepository.findAll();
        for (User user : list) {
            collection.add(UserDTO.fromUser(user));
        }

        return collection;
    }

    public UserDTO getUser(String username) {
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

    public String createUser(UserDTO userDTO) {
        User newUser = userRepository.save(UserDTO.toUser(userDTO));
        return newUser.getUsername();
    }

    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }


    public void updatePassword(String username, UserDTO newUser) {
        if (!userExists(username)) throw new RecordNotFoundException();
        User user = userRepository.findById(username).get();
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }

    public void updateEmail(String username, UserDTO newUser) {
        if (!userExists(username)) throw new RecordNotFoundException();
        User user = userRepository.findById(username).get();
        user.setEmail(newUser.getEmail());
        userRepository.save(user);
    }

    public void updateDob(String username, UserDTO newUser) {
        if (!userExists(username)) throw new RecordNotFoundException();
        User user = userRepository.findById(username).get();
        user.setDob(newUser.getDob());
        userRepository.save(user);
    }

    public void addFishSpotToUser(Long id,FishingSpotDTO fishingSpotDTO) {
        if (!userRepository.existsById(id)) throw new RecordNotFoundException();
        User user = userRepository.findById(id).get();

        //fishingSpotDTO mappen naar FishingSpot
                FishingSpot fishingSpot = new FishingSpot();

        user.addFishingSpots(fishingSpot);
        userRepository.save(user);

    }

}
