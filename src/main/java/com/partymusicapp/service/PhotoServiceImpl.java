package com.partymusicapp.service;

import com.partymusicapp.models.Photo;
import com.partymusicapp.models.User;
import com.partymusicapp.repository.PhotoRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService{

    PhotoRepo photoRepo;
    UserService userService;

    @Transactional
    public Photo savePhoto(MultipartFile file, String userId) throws IOException {
        User user = userService.getUserById(userId);

        Photo photo = new Photo();
        photo.setUserId(user);
        photo.setFilename(file.getOriginalFilename());
        photo.setFileType(file.getContentType());
        photo.setData(file.getBytes());

        photoRepo.save(photo);

        return photo;
    }

    @Transactional
    public void deletePhoto(String photoId) {
        Photo photo = photoRepo.findPhotoByPhotoId(photoId);
        if(photo != null)
            photoRepo.delete(photo);
    }

    public Optional<Photo> getPhoto(String photoId) {
        return photoRepo.findById(photoId);
    }

    public List<Photo> getAllPhotos() {
        return photoRepo.findAll().stream()
                .toList();
    }

    public List<Photo> getUserPhotos(String userId) {
        User user = userService.getUserById(userId);
        return photoRepo.findByUser(user);
    }

}
