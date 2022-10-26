package com.example.eindopdrachtbackendv1.DTOS;

import com.example.eindopdrachtbackendv1.models.Upload;

import java.time.LocalDateTime;

public class UploadDTO {

    public Long id;
    public double weightFish;
    public double lengthFish;

    public String charsFish;
    public String speciesFish;
    public String photoFish;

    public LocalDateTime timeCaughtFish;

    public static UploadDTO fromUpload (Upload upload) {

        UploadDTO dto = new UploadDTO();

        dto.setId(upload.getId());
        dto.setWeightFish(upload.getWeightFish());
        dto.setLengthFish(upload.getLengthFish());
        dto.setCharsFish(upload.getCharsFish());
        dto.setSpeciesFish(upload.getSpeciesFish());
        dto.setPhotoFish(upload.getPhotoFish());
        dto.setTimeCaughtFish(upload.getTimeCaughtFish());

        return dto;
    }

    public static Upload toUpload(UploadDTO uploadDTO) {

        Upload upload = new Upload();

        upload.setId(uploadDTO.id);
        upload.setWeightFish(uploadDTO.weightFish);
        upload.setLengthFish(uploadDTO.lengthFish);
        upload.setCharsFish(uploadDTO.charsFish);
        upload.setSpeciesFish(uploadDTO.speciesFish);
        upload.setPhotoFish(uploadDTO.photoFish);
        upload.setTimeCaughtFish(uploadDTO.timeCaughtFish);

        return upload;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getWeightFish() {
        return weightFish;
    }

    public void setWeightFish(double weightFish) {
        this.weightFish = weightFish;
    }

    public double getLengthFish() {
        return lengthFish;
    }

    public void setLengthFish(double lengthFish) {
        this.lengthFish = lengthFish;
    }

    public String getCharsFish() {
        return charsFish;
    }

    public void setCharsFish(String charsFish) {
        this.charsFish = charsFish;
    }

    public String getSpeciesFish() {
        return speciesFish;
    }

    public void setSpeciesFish(String speciesFish) {
        this.speciesFish = speciesFish;
    }

    public String getPhotoFish() {
        return photoFish;
    }

    public void setPhotoFish(String photoFish) {
        this.photoFish = photoFish;
    }

    public LocalDateTime getTimeCaughtFish() {
        return timeCaughtFish;
    }

    public void setTimeCaughtFish(LocalDateTime timeCaughtFish) {
        this.timeCaughtFish = timeCaughtFish;
    }
}
