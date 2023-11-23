package com.partymusicapp.service;

import com.partymusicapp.models.Photo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface PhotoService {
    @Transactional
    public Photo savePhoto(MultipartFile file, String userId) throws IOException;
}
