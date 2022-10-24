package com.example.eindopdrachtbackendv1.Services;

import com.example.eindopdrachtbackendv1.DTOS.PortfolioDTO;
import com.example.eindopdrachtbackendv1.Exceptions.RecordNotFoundException;
import com.example.eindopdrachtbackendv1.Repositories.PortfolioRepository;
import com.example.eindopdrachtbackendv1.models.Portfolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {
    @Autowired
    private final PortfolioRepository portfolioRepository;

    public PortfolioService (PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public List<PortfolioDTO> getAllPortfolios() {
        List <PortfolioDTO> collection = new ArrayList<>();
        List < Portfolio> list = portfolioRepository.findAll();
        for (Portfolio portfolio : list) {
            collection.add(PortfolioDTO.fromPortfolio(portfolio));
        }

        return collection;
    }

    public PortfolioDTO getPortfolio (String portfolio) {
        PortfolioDTO dto = new PortfolioDTO();
        Optional<Portfolio> port = portfolioRepository.findById(portfolio);
        if (port.isPresent()) {
            dto = PortfolioDTO.fromPortfolio(port.get());
        } else {
            throw new RecordNotFoundException(portfolio);
        }
        return dto;
    }

    public int createPortfolio (PortfolioDTO portfolioDTO) {
        Portfolio newPortfolio = portfolioRepository.save(PortfolioDTO.toPortfolio(portfolioDTO));
        return newPortfolio.getPortfolioID();
    }

    public void deletePortfolio (String portfolioID) {
        portfolioRepository.deleteById(portfolioID);
    }

    public void updatePortfolio (String portfolioID, PortfolioDTO newPortfolio) {
        if (!portfolioRepository.existsById(portfolioID)) throw new RecordNotFoundException();
        Portfolio portfolio = portfolioRepository.findById(portfolioID).get();
        portfolio.setCountFishingSpot(newPortfolio.getCountFishingSpot());
        portfolioRepository.save(portfolio);
    }
}


