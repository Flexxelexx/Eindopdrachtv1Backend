package com.example.eindopdrachtbackendv1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class User {

    @Id
    @Column
    private String fname;
    @Column
    private String lastname;
    @Column
    private String profilename;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private LocalDate dob;



    public User() {

    }

    public User(String fname, String lastname, String profilename, String password, String email, LocalDate dob) {
        this.fname = fname;
        this.lastname = lastname;
        this.profilename = profilename;
        this.password = password;
        this.email = email;
        this.dob = dob;
    }

    public String getName() {
        return fname;
    }

    public void setName(String fname) {
        this.fname = fname;
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
