package com.example.eindopdrachtbackendv1.repositories;

import com.example.eindopdrachtbackendv1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository <User, Long> {
}
