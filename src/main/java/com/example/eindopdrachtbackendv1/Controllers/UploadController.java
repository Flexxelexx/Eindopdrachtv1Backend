package com.example.eindopdrachtbackendv1.Controllers;

import com.example.eindopdrachtbackendv1.DTOS.UploadDTO;
import com.example.eindopdrachtbackendv1.Services.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @GetMapping(value = "")
    public ResponseEntity<List<UploadDTO>> getUploads() {

        List<UploadDTO> uploadDTOS = uploadService.getUploads();

        return ResponseEntity.ok().body(uploadDTOS);
    }

    @GetMapping(value = "/{upload}")
    public ResponseEntity<UploadDTO> getUpload(@PathVariable("upload") Long id) {

        UploadDTO optionalUpload = uploadService.getUpload(id);

        return ResponseEntity.ok().body(optionalUpload);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<UploadDTO> createUpload(@RequestBody UploadDTO id) {

        String newUpload = uploadService.createUpload(id).toString();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{upload}")
                .buildAndExpand(newUpload).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteUpload (@PathVariable Long id) {
        uploadService.deleteUpload(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}/updateweight")
    public ResponseEntity<UploadDTO> updateWeightFish (@PathVariable Long id, @RequestBody UploadDTO dto) {

        uploadService.updateWeightFish(id, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}/updatelength")
    public ResponseEntity<UploadDTO> updateLengthFish (@PathVariable Long id, @RequestBody UploadDTO dto) {

        uploadService.updateLengthFish(id, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}updatechars")
    public ResponseEntity<UploadDTO> updateCharsFish (@PathVariable Long id, @RequestBody UploadDTO dto) {

        uploadService.updateCharsFish(id, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}/updatespecies")
    public ResponseEntity<UploadDTO> updateSpeciesFish (@PathVariable Long id, @RequestBody UploadDTO dto) {

        uploadService.updateSpeciesFish(id, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}updatetime")
    public ResponseEntity<UploadDTO> updateTimeCaughtFish (@PathVariable Long id, @RequestBody UploadDTO dto) {

        uploadService.updateTimeCaughtFish(id, dto);

        return ResponseEntity.noContent().build();
    }


}
