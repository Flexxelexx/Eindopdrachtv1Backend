package com.example.eindopdrachtbackendv1.DTOS;

import com.example.eindopdrachtbackendv1.models.Rating;

public class RatingDTO {

    private String oneStar;
    private String twoStars;
    private String threeStars;
    private String fourStars;
    private String fiveStars;

    public static RatingDTO fromRating (Rating rating) {

        RatingDTO dto = new RatingDTO();

        dto.setOneStar(rating.getOneStar());
        dto.setTwoStars(rating.getTwoStars());
        dto.setThreeStars(rating.getThreeStars());
        dto.setFourStars(rating.getFourStars());
        dto.setFiveStars(rating.getFiveStars());

        return dto;
    }

    public Rating toRating() {

        Rating rating = new Rating();

        rating.setOneStar(this.getOneStar());
        rating.setTwoStars(this.getTwoStars());
        rating.setThreeStars(this.getThreeStars());
        rating.setFourStars(this.getFourStars());
        rating.setFiveStars(this.getFiveStars());

        return rating;
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
