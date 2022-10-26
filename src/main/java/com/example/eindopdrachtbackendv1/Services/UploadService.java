package com.example.eindopdrachtbackendv1.Services;


import com.example.eindopdrachtbackendv1.DTOS.UploadDTO;
import com.example.eindopdrachtbackendv1.Exceptions.RecordNotFoundException;
import com.example.eindopdrachtbackendv1.Repositories.UploadRepository;
import com.example.eindopdrachtbackendv1.models.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UploadService {

    @Autowired
    private final UploadRepository uploadRepository;

    public UploadService (UploadRepository uploadRepository) {
        this.uploadRepository = uploadRepository;
    }

    public List<UploadDTO> getUploads() {
        List <UploadDTO> collection = new ArrayList<>();
        List <Upload> list = uploadRepository.findAll();
        for (Upload upload : list ) {
            collection.add(UploadDTO.fromUpload(upload));
        }

        return collection;
    }

    public UploadDTO getUpload (Long id) {
        UploadDTO dto = new UploadDTO();
        Optional<Upload> uploadOptional = uploadRepository.findById(id);
        if (uploadOptional.isPresent()) {
            dto = UploadDTO.fromUpload(uploadOptional.get());
        } else {
            throw new RecordNotFoundException(id.toString());
        }
        return dto;
    }

    public Long createUpload (UploadDTO uploadDTO) {
        Upload newUpload = uploadRepository.save(UploadDTO.toUpload(uploadDTO));
        return newUpload.getId();
    }

    public void deleteUpload (Long id) {
        uploadRepository.deleteById(id);
    }

    public void updateWeightFish (Long id, UploadDTO newFish) {
        Upload upload = uploadRepository.findById(id).get();
        upload.setWeightFish(newFish.getWeightFish());
        uploadRepository.save(upload);
    }

    public void updateLengthFish (Long id, UploadDTO newFish) {
        Upload upload = uploadRepository.findById(id).get();
        upload.setLengthFish(newFish.getLengthFish());
        uploadRepository.save(upload);
    }

    public void updateCharsFish (Long id, UploadDTO newFish) {
        Upload upload = uploadRepository.findById(id).get();
        upload.setCharsFish(newFish.getCharsFish());
        uploadRepository.save(upload);
    }

    public void updateSpeciesFish (Long id, UploadDTO newFish) {
        Upload upload = uploadRepository.findById(id).get();
        upload.setSpeciesFish(newFish.getSpeciesFish());
        uploadRepository.save(upload);
    }

    public void updateTimeCaughtFish (Long id, UploadDTO newFish) {
        Upload upload = uploadRepository.findById(id).get();
        upload.setTimeCaughtFish(newFish.getTimeCaughtFish());
        uploadRepository.save(upload);
    }

//    public void updatePhotoFish (Long id, UploadDTO newFish) {
//        Upload upload = uploadRepository.findById(id).get();
//        upload.setPhotoFish(newFish.getPhotoFish());
//        uploadRepository.save(upload);
//    }

}
