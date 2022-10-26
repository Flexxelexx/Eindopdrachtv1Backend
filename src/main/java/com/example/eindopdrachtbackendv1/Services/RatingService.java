package com.example.eindopdrachtbackendv1.Services;

import com.example.eindopdrachtbackendv1.DTOS.RatingDTO;
import com.example.eindopdrachtbackendv1.Exceptions.RecordNotFoundException;
import com.example.eindopdrachtbackendv1.Repositories.RatingRepository;
import com.example.eindopdrachtbackendv1.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    private final RatingRepository ratingRepository;

    public RatingService (RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<RatingDTO> getRatings() {
        List <RatingDTO> collection = new ArrayList<>();
        List < Rating> list = ratingRepository.findAll();
        for (Rating rating : list) {
            collection.add(RatingDTO.fromRating(rating));
        }

        return collection;
    }

    public RatingDTO getRating (Long id) {
        RatingDTO dto = new RatingDTO();
        Optional<Rating> ratingOptional = ratingRepository.findById(id);
        if (ratingOptional.isPresent()) {
            dto = RatingDTO.fromRating(ratingOptional.get());
        } else {
            throw new RecordNotFoundException(id.toString());
        }
        return dto;
    }

    public Long createRating (RatingDTO ratingDTO) {
        Rating rating = ratingRepository.save(RatingDTO.toRating(ratingDTO));
        return rating.getId();
    }

    public void deleteRating  (Long id) {
        ratingRepository.deleteById(id);
    }

    public void updateOneStar (Long id,RatingDTO ratingDTO) {
        Rating rating = ratingRepository.findById(id).get();
        rating.setOneStar(ratingDTO.getOneStar());
        ratingRepository.save(rating);
    }

    public void updateTwoStars (Long id,RatingDTO ratingDTO) {
        Rating rating = ratingRepository.findById(id).get();
        rating.setTwoStars(ratingDTO.getTwoStars());
        ratingRepository.save(rating);
    }
    public void updateThreeStars (Long id,RatingDTO ratingDTO) {
        Rating rating = ratingRepository.findById(id).get();
        rating.setThreeStars(ratingDTO.getThreeStars());
        ratingRepository.save(rating);
    }

    public void updateFourStars (Long id,RatingDTO ratingDTO) {
        Rating rating = ratingRepository.findById(id).get();
        rating.setFourStars(ratingDTO.getFourStars());
        ratingRepository.save(rating);
    }

    public void updateFiveStars (Long id,RatingDTO ratingDTO) {
        Rating rating = ratingRepository.findById(id).get();
        rating.setFiveStars(ratingDTO.getFiveStars());
        ratingRepository.save(rating);
    }

}
