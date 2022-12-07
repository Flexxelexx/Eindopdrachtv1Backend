package com.example.eindopdrachtbackendv1.repositories;

import com.example.eindopdrachtbackendv1.models.Upload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadRepository extends JpaRepository <Upload, Long> {
}
