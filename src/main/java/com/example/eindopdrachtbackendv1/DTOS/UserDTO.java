package com.example.eindopdrachtbackendv1.DTOS;

import com.example.eindopdrachtbackendv1.models.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class UserDTO {

    @NotBlank
    public String name;
    @NotBlank
    public String lastname;
    @NotBlank
    public String profilename;
    @NotBlank
    @Size(min=6, max=20)
    public String password;
    public String apikey;
    @Email
    @NotBlank
    public String email;
    @NotBlank
    public LocalDate dob;


    public static UserDTO fromUser (User user) {

        UserDTO dto = new UserDTO();

        dto.setName(user.getName());
        dto.setLastname(user.getLastname());
        dto.setProfilename(user.getProfilename());
        dto.setPassword(user.getPassword());
        dto.setApikey(user.getApikey());
        dto.setEmail(user.getEmail());
        dto.setDob(user.getDob());

        return dto;
    }

    public User toUser() {

        User user = new User();

        user.setName(this.getName());
        user.setLastname(this.getLastname());
        user.setProfilename(this.getProfilename());
        user.setPassword(this.getPassword());
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

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getProfilename() {
        return profilename;
    }
    public void setProfilename(String profilename) {
        this.profilename = profilename;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getApikey() {
        return apikey;
    }
    public void setApikey(String apikey) {
        this.apikey = apikey;
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
