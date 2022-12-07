package com.example.eindopdrachtbackendv1.dto;

import com.example.eindopdrachtbackendv1.models.FishingSpot;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class FishingSpotDTO {
    @Id
    @NotBlank
    private String spotLocation;


    public static FishingSpotDTO fromFishingSpot(FishingSpot fishingSpot) {

        FishingSpotDTO dto = new FishingSpotDTO();

        dto.setSpotLocation(fishingSpot.getSpotLocation());


        return dto;
    }

    public static FishingSpot toFishingspot(FishingSpotDTO fishingSpotDTO) {

        FishingSpot fishingSpot = new FishingSpot();

        fishingSpot.setSpotLocation(fishingSpotDTO.getSpotLocation());


        return fishingSpot;
    }

    public String getSpotLocation() {
        return spotLocation;
    }

    public void setSpotLocation(String spotLocation) {
        this.spotLocation = spotLocation;
    }

}
