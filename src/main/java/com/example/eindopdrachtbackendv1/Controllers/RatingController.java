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
@RequestMapping(value = "/ratings")
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

    @PostMapping("/create")
    public ResponseEntity<RatingDTO> createRating(@RequestBody RatingDTO id) {

        String newRating = String.valueOf(ratingService.createRating(id));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{rating}")
                .buildAndExpand(newRating).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteRating(@PathVariable Long id) {
        ratingService.deleteRating(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}/giveonestar")
    public ResponseEntity <RatingDTO> updateOneStar (@PathVariable Long id, @RequestBody RatingDTO dto) {

        ratingService.updateOneStar(id, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}/givetwostars")
    public ResponseEntity <RatingDTO> updateTwoStars (@PathVariable Long id, @RequestBody RatingDTO dto) {

        ratingService.updateTwoStars(id, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}/givethreestars")
    public ResponseEntity <RatingDTO> updateThreeStars (@PathVariable Long id, @RequestBody RatingDTO dto) {

        ratingService.updateThreeStars(id, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}/givefourstars")
    public ResponseEntity <RatingDTO> updateFourStars (@PathVariable Long id, @RequestBody RatingDTO dto) {

        ratingService.updateFourStars(id, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}/givefivestars")
    public ResponseEntity <RatingDTO> updateFiveStars (@PathVariable Long id, @RequestBody RatingDTO dto) {

        ratingService.updateFiveStars(id, dto);

        return ResponseEntity.noContent().build();
    }
}
