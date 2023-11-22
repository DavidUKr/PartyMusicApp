package com.partymusicapp.repository;

import com.partymusicapp.models.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepo extends JpaRepository<Photo, String> {
    Photo findPhotoByPhotoId(String photoId);
}
