package com.example.eindopdrachtbackendv1.Services;

import com.example.eindopdrachtbackendv1.dto.FishingSpotDTO;
import com.example.eindopdrachtbackendv1.dto.UserDTO;
import com.example.eindopdrachtbackendv1.dto.input.UserInputDto;
import com.example.eindopdrachtbackendv1.dto.output.UserOutputDto;
import com.example.eindopdrachtbackendv1.exceptions.RecordNotFoundException;
import com.example.eindopdrachtbackendv1.repositories.UserRepository;
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
    private UserRepository userRepository;
    public List<UserOutputDto> getAllUsers() {

        List<User> usersList = userRepository.findAll();
        List<UserOutputDto> userOutputDtoList = new ArrayList<>();

        for(User user : usersList){
            userOutputDtoList.add(userToUserOutputDto(user));
        }

        return userOutputDtoList;
    }

    public UserOutputDto getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.format("User with id %d not found", id)));

        return userToUserOutputDto(user);
    }

    public UserOutputDto createUser(UserInputDto inputUser) {

        User user = userInputDtoToUser(inputUser);
        userRepository.save(user);

        return  userToUserOutputDto(user);

    }

    //Helper functions

    private UserOutputDto userToUserOutputDto(User user){

        UserOutputDto userOutputDto = new UserOutputDto();
        userOutputDto.setId(user.getId());

        return userOutputDto;
    }

    private User userInputDtoToUser(UserInputDto userInputDto){

        User user = new User();
        user.setId(userInputDto.getId());

        return user;
    }

    public UserOutputDto updateUser(UserInputDto userInput) {

        Long inputId = userInput.getId();

        User user = userRepository.findById(inputId).map(x -> userInputDtoToUser(userInput))
                .orElseThrow(() -> new RecordNotFoundException(String.format("User with id %d not found", inputId)));

        userRepository.save(user);

        return userToUserOutputDto(user);

    }

    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                        .orElseThrow(() -> new RecordNotFoundException(String.format("User with id %d not found", id)));

        userRepository.deleteById(id);

    }
}
