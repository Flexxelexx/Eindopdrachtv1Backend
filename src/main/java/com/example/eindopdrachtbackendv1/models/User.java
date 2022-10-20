package com.example.eindopdrachtbackendv1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class User {

    @Id
    @Column
    private String name;
    @Column
    private String lastname;
    @Column
    private String profilename;
    @Column
    private String password;
    @Column
    private String apikey;
    @Column
    private String email;
    @Column
    private LocalDate dob;



    public User() {

    }

    public User(String name, String lastname, String profilename, String password, String apikey, String email, LocalDate dob) {
        this.name = name;
        this.lastname = lastname;
        this.profilename = profilename;
        this.password = password;
        this.apikey = apikey;
        this.email = email;
        this.dob = dob;
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
