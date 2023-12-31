package com.partymusicapp.Controllers;

import com.partymusicapp.models.Photo;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/pma/api/v1/upload")
public interface PhotoController {

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<Photo> handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("userId") String userId);

    @DeleteMapping("/delete/{photoId}")
    ResponseEntity<String> deletePhoto(@PathVariable String photoId);

    @GetMapping("/get/{photoId}")
    ResponseEntity<Photo> getPhoto(@PathVariable String photoId);

    @GetMapping("/getAll")
    ResponseEntity<List<Photo>> getAllPhotos();

    @GetMapping("/getUserPhotos/{userId}")
    ResponseEntity<List<Photo>> getUserPhotos(@PathVariable String userId);
}
