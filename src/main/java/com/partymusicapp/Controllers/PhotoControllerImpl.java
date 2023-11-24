package com.partymusicapp.Controllers;

import com.partymusicapp.models.Photo;
import com.partymusicapp.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/pma/api/v1/upload")
@RequiredArgsConstructor
public class PhotoControllerImpl implements PhotoController {

    private final PhotoService photoService;

    @Override
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Photo>  handleFileUpload(MultipartFile file, String userId) {
        try {
            Photo savedPhoto = photoService.savePhoto(file, userId);
            return ResponseEntity.ok(savedPhoto);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    @DeleteMapping("/delete/{photoId}")
    public ResponseEntity<String> deletePhoto(String photoId) {
        photoService.deletePhoto(photoId);
        return ResponseEntity.ok("Photo deleted successfully");
    }

    @Override
    @GetMapping("/get/{photoId}")
    public ResponseEntity<Photo> getPhoto(String photoId) {
        return photoService.getPhoto(photoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @GetMapping("/getAll")
    public ResponseEntity<List<Photo>> getAllPhotos() {
        List<Photo> photos = photoService.getAllPhotos();
        return ResponseEntity.ok(photos);
    }

    @Override
    @GetMapping("/getUserPhotos/{userId}")
    public ResponseEntity<List<Photo>> getUserPhotos(String userId) {
        List<Photo> userPhotos = photoService.getUserPhotos(userId);
        return ResponseEntity.ok(userPhotos);
    }


}
