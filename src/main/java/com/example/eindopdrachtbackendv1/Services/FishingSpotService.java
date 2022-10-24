package com.example.eindopdrachtbackendv1.Services;

import com.example.eindopdrachtbackendv1.DTOS.FishingSpotDTO;
import com.example.eindopdrachtbackendv1.Exceptions.RecordNotFoundException;
import com.example.eindopdrachtbackendv1.Repositories.FishingSpotRepository;
import com.example.eindopdrachtbackendv1.models.FishingSpot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FishingSpotService {

    @Autowired
    private final FishingSpotRepository fishingSpotRepository;

    public FishingSpotService(FishingSpotRepository fishingSpotRepository) {
        this.fishingSpotRepository = fishingSpotRepository;
    }

    public List<FishingSpotDTO> getFishingSpots() {
        List<FishingSpotDTO> collection = new ArrayList<>();
        List<FishingSpot> list = fishingSpotRepository.findAll();
        for (FishingSpot fishingSpot : list) {
            collection.add(FishingSpotDTO.fromFishingSpot(fishingSpot));
        }

        return collection;
    }

    public FishingSpotDTO getFishingSpot(String fishingspot) {
        FishingSpotDTO dto = new FishingSpotDTO();
        Optional<FishingSpot> user = fishingSpotRepository.findById(fishingspot);
        if (user.isPresent()) {
            dto = FishingSpotDTO.fromFishingSpot(user.get());
        } else {
            throw new RecordNotFoundException(fishingspot);
        }
        return dto;
    }

    public String createFishingSpot(FishingSpotDTO fishingSpotDTO) {
        FishingSpot newFishingSpot = fishingSpotRepository.save(FishingSpotDTO.toFishingspot(fishingSpotDTO));
        return newFishingSpot.getSpotLocation();
    }

    public void deleteFishingSpot(String fishingspot) {
        fishingSpotRepository.deleteById(fishingspot);
    }

    public void updateCaughtFish (String caughtFish, FishingSpotDTO newFish) {
        FishingSpot fishingSpot = fishingSpotRepository.findById(caughtFish).get();
        fishingSpot.setCaughtFish(newFish.getCaughtFish());
        fishingSpotRepository.save(fishingSpot);
    }
    public void updateSpotLocation(String spotLocation, FishingSpotDTO newFishingSpot) {
        FishingSpot fishingSpot = fishingSpotRepository.findById(spotLocation).get();
        fishingSpot.setSpotLocation(newFishingSpot.getSpotLocation());
        fishingSpotRepository.save(fishingSpot);
    }

    public void updateTimeAndDateCaught (LocalDateTime timeAndDateCaught, FishingSpotDTO newCaughtTime) {
        FishingSpot fishingSpot = fishingSpotRepository.(newCaughtTime);
        fishingSpot.setTimeAndDateCaught(newCaughtTime.getTimeAndDateCaught());
        fishingSpotRepository.save(fishingSpot);
    }





}
