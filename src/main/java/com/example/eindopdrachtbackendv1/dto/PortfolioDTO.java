package com.example.eindopdrachtbackendv1.dto;

import com.example.eindopdrachtbackendv1.models.Portfolio;

public class PortfolioDTO {


    private double countFishingSpot;
    private Long portfolioID;

    public static PortfolioDTO fromPortfolio (Portfolio portfolio) {

        PortfolioDTO dto = new PortfolioDTO();

        dto.setCountFishingSpot(portfolio.getCountFishingSpot());
        dto.setPortfolioID(portfolio.getPortfolioID());

        return dto;
    }

    public static Portfolio toPortfolio(PortfolioDTO portfolioDTO) {

        Portfolio portfolio = new Portfolio();

        portfolio.setCountFishingSpot(portfolioDTO.getCountFishingSpot());
        portfolio.setPortfolioID(portfolioDTO.getPortfolioID());

        return portfolio;
    }


    public double getCountFishingSpot() {
        return countFishingSpot;
    }
    public void setCountFishingSpot(double countFishingSpot) {
        this.countFishingSpot = countFishingSpot;
    }

    public Long getPortfolioID() {
        return portfolioID;
    }

    public void setPortfolioID(Long portfolioID) {
        this.portfolioID = portfolioID;
    }
}
