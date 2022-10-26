package com.example.eindopdrachtbackendv1.DTOS;

import com.example.eindopdrachtbackendv1.models.Rating;

public class RatingDTO {

    private Long id;
    private String oneStar;
    private String twoStars;
    private String threeStars;
    private String fourStars;
    private String fiveStars;

    public static RatingDTO fromRating (Rating rating) {

        RatingDTO dto = new RatingDTO();

        dto.setId(rating.getId());
        dto.setOneStar(rating.getOneStar());
        dto.setTwoStars(rating.getTwoStars());
        dto.setThreeStars(rating.getThreeStars());
        dto.setFourStars(rating.getFourStars());
        dto.setFiveStars(rating.getFiveStars());

        return dto;
    }

    public static Rating toRating(RatingDTO ratingDTO) {

        Rating rating = new Rating();

        rating.setId(ratingDTO.id);
        rating.setOneStar(ratingDTO.oneStar);
        rating.setTwoStars(ratingDTO.twoStars);
        rating.setThreeStars(ratingDTO.threeStars);
        rating.setFourStars(ratingDTO.fourStars);
        rating.setFiveStars(ratingDTO.fiveStars);

        return rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOneStar() {
        return oneStar;
    }

    public void setOneStar(String oneStar) {
        this.oneStar = oneStar;
    }

    public String getTwoStars() {
        return twoStars;
    }

    public void setTwoStars(String twoStars) {
        this.twoStars = twoStars;
    }

    public String getThreeStars() {
        return threeStars;
    }

    public void setThreeStars(String threeStars) {
        this.threeStars = threeStars;
    }

    public String getFourStars() {
        return fourStars;
    }

    public void setFourStars(String fourStars) {
        this.fourStars = fourStars;
    }

    public String getFiveStars() {
        return fiveStars;
    }

    public void setFiveStars(String fiveStars) {
        this.fiveStars = fiveStars;
    }
}
