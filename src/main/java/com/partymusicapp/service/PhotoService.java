package com.partymusicapp.service;

import com.partymusicapp.models.Photo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public interface PhotoService {
    @Transactional
    Photo savePhoto(MultipartFile file, String userId) throws IOException;

    void deletePhoto(String photoId);

    Optional<Photo> getPhoto(String photoId);

    List<Photo> getAllPhotos();

    List<Photo> getUserPhotos(String userId);
}
