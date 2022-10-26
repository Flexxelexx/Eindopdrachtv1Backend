package com.example.eindopdrachtbackendv1.DTOS;

import com.example.eindopdrachtbackendv1.models.FishingSpot;

import javax.validation.constraints.NotBlank;

public class FishingSpotDTO {

    private Long id;
    @NotBlank
    private String spotLocation;


    public static FishingSpotDTO fromFishingSpot(FishingSpot fishingSpot) {

        FishingSpotDTO dto = new FishingSpotDTO();

        dto.setId(fishingSpot.getId());
        dto.setSpotLocation(fishingSpot.getSpotLocation());


        return dto;
    }

    public static FishingSpot toFishingspot(FishingSpotDTO fishingSpotDTO) {

        FishingSpot fishingSpot = new FishingSpot();

        fishingSpot.setId(fishingSpotDTO.getId());
        fishingSpot.setSpotLocation(fishingSpotDTO.getSpotLocation());


        return fishingSpot;
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
