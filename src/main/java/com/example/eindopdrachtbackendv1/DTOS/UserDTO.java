package com.example.eindopdrachtbackendv1.DTOS;

import com.example.eindopdrachtbackendv1.models.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class UserDTO {

    public Long id;
    @NotBlank
    public String profilename;
    @NotBlank
    @Size(min = 6, max = 20)
    public String password;
    @Email
    @NotBlank
    public String email;
    @Past
    @NotBlank
    public LocalDate dob;


    public static UserDTO fromUser(User user) {

        UserDTO dto = new UserDTO();

        dto.setId(user.getId());
        dto.setProfilename(user.getProfilename());
        dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());
        dto.setDob(user.getDob());

        return dto;
    }

    public static User toUser(UserDTO userDTO) {

        User user = new User();

        user.setId(userDTO.id);
        user.setProfilename(userDTO.profilename);
        user.setPassword(userDTO.password);
        user.setEmail(userDTO.email);
        user.setDob(userDTO.dob);

        return user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
