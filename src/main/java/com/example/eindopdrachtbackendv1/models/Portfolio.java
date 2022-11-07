package com.example.eindopdrachtbackendv1.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "portfolios")
public class Portfolio {

    @Id
    @GeneratedValue
    @Column
    private Long portfolioID;
    @Column
    private double countFishingSpot;

    @OneToOne(fetch = FetchType.EAGER)
    private User users;

    public Portfolio() {

    }

    public Portfolio(Long portfolioID, double countFishingSpot, User users) {
        this.portfolioID = portfolioID;
        this.countFishingSpot = countFishingSpot;
        this.users = users;
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

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
}
