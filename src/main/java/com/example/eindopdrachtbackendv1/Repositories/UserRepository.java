package com.example.eindopdrachtbackendv1.Repositories;

import com.example.eindopdrachtbackendv1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, String> {
}
