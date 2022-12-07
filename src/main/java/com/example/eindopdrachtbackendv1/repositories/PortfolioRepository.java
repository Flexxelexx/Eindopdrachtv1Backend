package com.example.eindopdrachtbackendv1.repositories;

import com.example.eindopdrachtbackendv1.models.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository <Portfolio, Long> {
}
