package com.partymusicapp.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/pma/api/v1/upload")
public interface PhotoController {

    @PostMapping
    public String handleFileUpload(@RequestParam("file")MultipartFile file);
}
