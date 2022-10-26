package com.example.eindopdrachtbackendv1.models;

import javax.persistence.*;

@Entity
@Table(name = "fishingspots")
public class FishingSpot {

    @Id
    @GeneratedValue
    Long id;

    @Column
    private String spotLocation;



    public FishingSpot() {

    }

    public FishingSpot(Long id, String spotLocation) {
        this.id = id;
        this.spotLocation = spotLocation;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpotLocation() {
        return spotLocation;
    }

    public void setSpotLocation(String spotLocation) {
        this.spotLocation = spotLocation;
    }

}
