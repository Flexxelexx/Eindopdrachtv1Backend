package com.example.eindopdrachtbackendv1.Controllers;

import com.example.eindopdrachtbackendv1.DTOS.RatingDTO;
import com.example.eindopdrachtbackendv1.Services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping(value = "")
    public ResponseEntity<List<RatingDTO>> getRatings() {

        List<RatingDTO> ratingDTOS = ratingService.getRatings();

        return ResponseEntity.ok().body(ratingDTOS);
    }

    @GetMapping(value = "/{rating}")
    public ResponseEntity<RatingDTO> getRating(@PathVariable("rating") Long id) {

        RatingDTO ratingDTO = ratingService.getRating(id);

        return ResponseEntity.ok().body(ratingDTO);
    }

    @PostMapping("")
    public ResponseEntity<RatingDTO> createRating(@RequestBody RatingDTO id) {

        String newRating = String.valueOf(ratingService.createRating(id));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{rating}")
                .buildAndExpand(newRating).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/{rating}")
    public ResponseEntity<Object> deleteRating(@PathVariable("rating") Long id) {
        ratingService.deleteRating(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{rating}")
    public ResponseEntity <RatingDTO> updateOneStar (@PathVariable("rating") Long id, @RequestBody RatingDTO dto) {

        ratingService.updateOneStar(id, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{rating}")
    public ResponseEntity <RatingDTO> updateTwoStars (@PathVariable("rating") Long id, @RequestBody RatingDTO dto) {

        ratingService.updateTwoStars(id, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{rating}")
    public ResponseEntity <RatingDTO> updateThreeStars (@PathVariable("rating") Long id, @RequestBody RatingDTO dto) {

        ratingService.updateThreeStars(id, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{rating}")
    public ResponseEntity <RatingDTO> updateFourStars (@PathVariable("rating") Long id, @RequestBody RatingDTO dto) {

        ratingService.updateFourStars(id, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{rating}")
    public ResponseEntity <RatingDTO> updateFiveStars (@PathVariable("rating") Long id, @RequestBody RatingDTO dto) {

        ratingService.updateFiveStars(id, dto);

        return ResponseEntity.noContent().build();
    }
}
