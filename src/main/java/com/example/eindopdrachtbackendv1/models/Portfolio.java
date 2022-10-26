package com.example.eindopdrachtbackendv1.models;

import javax.persistence.*;

@Entity
@Table(name = "portfolios")
public class Portfolio {

    @Id
    @GeneratedValue
    @Column
    private Long portfolioID;
    @Column
    private double countFishingSpot;


    public Portfolio() {

    }

    public Portfolio(Long portfolioID, double countFishingSpot) {
        this.portfolioID = portfolioID;
        this.countFishingSpot = countFishingSpot;
    }

    public Long getPortfolioID() {
        return portfolioID;
    }

    public void setPortfolioID(Long portfolioID) {
        this.portfolioID = portfolioID;
    }

    public double getCountFishingSpot() {
        return countFishingSpot;
    }

    public void setCountFishingSpot(double countFishingSpot) {
        this.countFishingSpot = countFishingSpot;
    }
}
