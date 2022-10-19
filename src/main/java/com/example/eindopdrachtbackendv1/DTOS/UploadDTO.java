package com.example.eindopdrachtbackendv1.DTOS;

import com.example.eindopdrachtbackendv1.models.Upload;

import java.time.LocalDateTime;

public class UploadDTO {

    private double weightFish;
    private double lengthFish;

    private String charsFish;
    private String speciesFish;
    private String photoFish;

    private LocalDateTime timeCaughtFish;

    public static UploadDTO fromUpload (Upload upload) {

        UploadDTO dto = new UploadDTO();

        dto.setWeightFish(upload.getWeightFish());
        dto.setLengthFish(upload.getLengthFish());
        dto.setCharsFish(upload.getCharsFish());
        dto.setSpeciesFish(upload.getSpeciesFish());
        dto.setPhotoFish(upload.getPhotoFish());
        dto.setTimeCaughtFish(upload.getTimeCaughtFish());

        return dto;
    }

    public Upload toUpload() {

        Upload upload = new Upload();

        upload.setWeightFish(this.getWeightFish());
        upload.setLengthFish(this.getLengthFish());
        upload.setCharsFish(this.getCharsFish());
        upload.setSpeciesFish(this.getSpeciesFish());
        upload.setPhotoFish(this.getPhotoFish());
        upload.setTimeCaughtFish(this.getTimeCaughtFish());

        return upload;
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
