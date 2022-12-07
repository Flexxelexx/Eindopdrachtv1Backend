package com.example.eindopdrachtbackendv1.repositories;

import com.example.eindopdrachtbackendv1.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository <Rating, Long> {
}
