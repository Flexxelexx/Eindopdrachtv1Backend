package com.example.eindopdrachtbackendv1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Upload {

    @Id
    private Long id;
    @Column
    private double weightFish;
    @Column
    private double lengthFish;
    @Column
    private String charsFish;
    @Column
    private String speciesFish;
    @Column
    private String photoFish;
    @Column
    private LocalDateTime timeCaughtFish;


    public Upload() {

    }

    public Upload(Long id, double weightFish, double lengthFish, String charsFish, String speciesFish, String photoFish, LocalDateTime timeCaughtFish) {
        this.id = id;
        this.weightFish = weightFish;
        this.lengthFish = lengthFish;
        this.charsFish = charsFish;
        this.speciesFish = speciesFish;
        this.photoFish = photoFish;
        this.timeCaughtFish = timeCaughtFish;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getWeightFish() {
        return weightFish;
    }

    public void setWeightFish(double weightFish) {
        this.weightFish = weightFish;
    }

    public double getLengthFish() {
        return lengthFish;
    }

    public void setLengthFish(double lengthFish) {
        this.lengthFish = lengthFish;
    }

    public String getCharsFish() {
        return charsFish;
    }

    public void setCharsFish(String charsFish) {
        this.charsFish = charsFish;
    }

    public String getSpeciesFish() {
        return speciesFish;
    }

    public void setSpeciesFish(String speciesFish) {
        this.speciesFish = speciesFish;
    }

    public String getPhotoFish() {
        return photoFish;
    }

    public void setPhotoFish(String photoFish) {
        this.photoFish = photoFish;
    }

    public LocalDateTime getTimeCaughtFish() {
        return timeCaughtFish;
    }

    public void setTimeCaughtFish(LocalDateTime timeCaughtFish) {
        this.timeCaughtFish = timeCaughtFish;
    }
}
