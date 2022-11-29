package com.example.eindopdrachtbackendv1.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "fishingspots")
public class FishingSpot {

    @Id
    private Long id;

    @Column
    private String spotLocation;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<User> users;


    public FishingSpot() {

    }

    public FishingSpot(String spotLocation, Collection<User> users) {
        this.spotLocation = spotLocation;
        this.users = users;
    }


    public String getSpotLocation() {
        return spotLocation;
    }

    public void setSpotLocation(String spotLocation) {
        this.spotLocation = spotLocation;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public void addUserToSpot(User user) {
        users.add(user);
    }
}
