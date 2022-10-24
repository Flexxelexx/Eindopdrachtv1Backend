package com.example.eindopdrachtbackendv1.DTOS;

import com.example.eindopdrachtbackendv1.models.Portfolio;

public class PortfolioDTO {

    private double countFish;
    private double countFishingSpot;

    private int portfolioID;

    public static PortfolioDTO fromPortfolio (Portfolio portfolio) {

        PortfolioDTO dto = new PortfolioDTO();

        dto.setCountFish(portfolio.getCountFish());
        dto.setCountFishingSpot(portfolio.getCountFishingSpot());
        dto.setPortfolioID(portfolio.getPortfolioID());

        return dto;
    }

    public static Portfolio toPortfolio(PortfolioDTO portfolioDTO) {

        Portfolio portfolio = new Portfolio();

        portfolio.setCountFish(portfolioDTO.getCountFish());
        portfolio.setCountFishingSpot(portfolioDTO.getCountFishingSpot());
        portfolio.setPortfolioID(portfolioDTO.getPortfolioID());

        return portfolio;
    }

    public double getCountFish() {
        return countFish;
    }

    public void setCountFish(double countFish) {
        this.countFish = countFish;
    }

    public double getCountFishingSpot() {
        return countFishingSpot;
    }

    public void setCountFishingSpot(double countFishingSpot) {
        this.countFishingSpot = countFishingSpot;
    }

    public int getPortfolioID() {
        return portfolioID;
    }

    public void setPortfolioID(int portfolioID) {
        this.portfolioID = portfolioID;
    }
}
