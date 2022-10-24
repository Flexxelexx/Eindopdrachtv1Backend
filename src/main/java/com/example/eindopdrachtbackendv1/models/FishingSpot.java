package com.example.eindopdrachtbackendv1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class FishingSpot {


    @Column
    private double caughtFish;
    @Id
    @Column
    private String spotLocation;
    @Column
    private LocalDateTime timeAndDateCaught;


    public FishingSpot() {

    }

    public FishingSpot(double caughtFish, String spotLocation, LocalDateTime timeCaught) {
        this.caughtFish = caughtFish;
        this.spotLocation = spotLocation;
        this.timeAndDateCaught = timeCaught;
    }

    public double getCaughtFish() {
        return caughtFish;
    }

    public void setCaughtFish(double caughtFish) {
        this.caughtFish = caughtFish;
    }

    public String getSpotLocation() {
        return spotLocation;
    }

    public void setSpotLocation(String spotLocation) {
        this.spotLocation = spotLocation;
    }

    public LocalDateTime getTimeAndDateCaught() {
        return timeAndDateCaught;
    }

    public void setTimeAndDateCaught(LocalDateTime timeAndDateCaught) {
        this.timeAndDateCaught = timeAndDateCaught;
    }
}
