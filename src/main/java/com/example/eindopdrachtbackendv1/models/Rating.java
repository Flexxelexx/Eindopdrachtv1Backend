package com.example.eindopdrachtbackendv1.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rating {

    @Id
    @GeneratedValue
    private String oneStar;
    private String twoStars;
    private String threeStars;
    private String fourStars;
    private String fiveStars;


    public Rating() {

    }

    public Rating(String oneStar, String twoStars, String threeStars, String fourStars, String fiveStars) {
        this.oneStar = oneStar;
        this.twoStars = twoStars;
        this.threeStars = threeStars;
        this.fourStars = fourStars;
        this.fiveStars = fiveStars;
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
