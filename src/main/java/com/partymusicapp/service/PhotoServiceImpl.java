package com.partymusicapp.service;

import com.partymusicapp.models.Photo;
import com.partymusicapp.models.User;
import com.partymusicapp.repository.PhotoRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

}
