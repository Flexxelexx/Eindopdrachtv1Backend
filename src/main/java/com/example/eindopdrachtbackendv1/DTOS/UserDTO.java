package com.example.eindopdrachtbackendv1.DTOS;

import com.example.eindopdrachtbackendv1.models.User;

import java.time.LocalDate;

public class UserDTO {

    private String name;
    private String lastName;
    private String profileName;
    private String email;

    private LocalDate dob;

    public static UserDTO fromUser (User user) {

        UserDTO dto = new UserDTO();

        dto.setName(user.getName());
        dto.setLastName(user.getLastName());
        dto.setProfileName(user.getProfileName());
        dto.setEmail(user.getEmail());
        dto.setDob(user.getDob());

        return dto;
    }

    public User toUser() {

        User user = new User();

        user.setName(this.getName());
        user.setLastName(this.getLastName());
        user.setProfileName(this.getProfileName());
        user.setEmail(this.getEmail());
        user.setDob(this.getDob());

        return user;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
