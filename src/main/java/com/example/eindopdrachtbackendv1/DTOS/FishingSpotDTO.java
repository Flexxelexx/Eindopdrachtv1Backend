package com.example.eindopdrachtbackendv1.DTOS;

import com.example.eindopdrachtbackendv1.models.FishingSpot;

import java.time.LocalTime;

public class FishingSpotDTO {

    private double caughtFish;

    //    private double location;
//    hoe moet ik dit gaan vertalen ^^ ??

    private LocalTime timeCaught;

    public static FishingSpotDTO fromFishingSpot (FishingSpot fishingSpot) {

        FishingSpotDTO dto = new FishingSpotDTO();

        dto.setCaughtFish(fishingSpot.getCaughtFish());
        dto.setTimeCaught(fishingSpot.getTimeCaught());

        return dto;
    }

    public FishingSpot toFishingspot() {

        FishingSpot fishingSpot = new FishingSpot();

        fishingSpot.setCaughtFish(this.getCaughtFish());
        fishingSpot.setTimeCaught(this.getTimeCaught());

        return fishingSpot;
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
