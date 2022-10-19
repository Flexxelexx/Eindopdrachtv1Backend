package com.example.eindopdrachtbackendv1.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalTime;

@Entity
public class FishingSpot {

    @Id
    @GeneratedValue
    private double caughtFish;

//    private double location;
//    hoe moet ik dit gaan vertalen ^^ ??
    private LocalTime timeCaught;


    public FishingSpot() {

    }

    public FishingSpot(double caughtFish, LocalTime timeCaught) {
        this.caughtFish = caughtFish;
        this.timeCaught = timeCaught;
    }

    public double getCaughtFish() {
        return caughtFish;
    }

    public void setCaughtFish(double caughtFish) {
        this.caughtFish = caughtFish;
    }

    public LocalTime getTimeCaught() {
        return timeCaught;
    }

    public void setTimeCaught(LocalTime timeCaught) {
        this.timeCaught = timeCaught;
    }
}
