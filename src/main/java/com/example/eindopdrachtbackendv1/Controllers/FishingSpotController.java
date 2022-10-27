package com.example.eindopdrachtbackendv1.Controllers;

import com.example.eindopdrachtbackendv1.DTOS.FishingSpotDTO;
import com.example.eindopdrachtbackendv1.Services.FishingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/fishingspot")
public class FishingSpotController {

   @Autowired
    private FishingSpotService fishingSpotService;

   @GetMapping(value = "")
    public ResponseEntity<List<FishingSpotDTO>> getFisingSpots() {

       List<FishingSpotDTO> fishingSpotDTOS = fishingSpotService.getFishingSpots();

       return ResponseEntity.ok().body(fishingSpotDTOS);
   }

   @GetMapping(value = "/{fishingspot}")
    public ResponseEntity<FishingSpotDTO> getFishingSpot(@PathVariable("fishingspot") Long id) {

       FishingSpotDTO optionalFishingSpot = fishingSpotService.getFishingSpot(id);

       return ResponseEntity.ok().body(optionalFishingSpot);
   }

   @PostMapping(value = "/create")
    public ResponseEntity<FishingSpotDTO> createFishingSpot(@RequestBody FishingSpotDTO id) {

       String newFishingspot = fishingSpotService.createFishingSpot(id);

       URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{fishingspot}")
               .buildAndExpand(newFishingspot).toUri();

       return ResponseEntity.created(location).build();
   }

   @PostMapping(value = "/{id}/updatelocation")
    public ResponseEntity<FishingSpotDTO> updateSpotLocation (@PathVariable Long id, @RequestBody FishingSpotDTO dto) {

       fishingSpotService.updateSpotLocation(id, dto);

       return ResponseEntity.noContent().build();

   }
}
