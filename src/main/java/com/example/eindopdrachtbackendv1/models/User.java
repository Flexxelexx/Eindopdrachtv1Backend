package com.example.eindopdrachtbackendv1.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column
    Long id;

    @Column
    private String profilename;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private LocalDate dob;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Roles> roles;

    public User() {

    }

    public User(Long id, String profilename, String password, String email, LocalDate dob) {
        this.id = id;
        this.profilename = profilename;
        this.password = password;
        this.email = email;
        this.dob = dob;
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
