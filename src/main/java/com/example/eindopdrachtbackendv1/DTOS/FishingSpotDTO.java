package com.example.eindopdrachtbackendv1.DTOS;

import com.example.eindopdrachtbackendv1.models.FishingSpot;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;


public class FishingSpotDTO {
    @NotBlank
    private double caughtFish;
    @NotBlank
    private String spotLocation;
    @NotBlank
    @Past
    private LocalDateTime timeAndDateCaught;


    public static FishingSpotDTO fromFishingSpot(FishingSpot fishingSpot) {

        FishingSpotDTO dto = new FishingSpotDTO();

        dto.setCaughtFish(fishingSpot.getCaughtFish());
        dto.setSpotLocation(fishingSpot.getSpotLocation());
        dto.setTimeAndDateCaught(fishingSpot.getTimeCaught());

        return dto;
    }

    public static FishingSpot toFishingspot(FishingSpotDTO fishingSpotDTO) {

        FishingSpot fishingSpot = new FishingSpot();

        fishingSpot.setCaughtFish(fishingSpotDTO.getCaughtFish());
        fishingSpot.setSpotLocation(fishingSpotDTO.getSpotLocation());
        fishingSpot.setTimeCaught(fishingSpotDTO.getTimeAndDateCaught());

        return fishingSpot;
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
