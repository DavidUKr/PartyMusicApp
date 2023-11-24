package com.partymusicapp.repository;

import com.partymusicapp.models.Photo;
import com.partymusicapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepo extends JpaRepository<Photo, String> {
    Photo findPhotoById(String photoId);

    List<Photo> findAllByUserId(User userId);
}

