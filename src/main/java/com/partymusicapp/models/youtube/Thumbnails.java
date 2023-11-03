package com.partymusicapp.models.youtube;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Data
@RequiredArgsConstructor
public class Thumbnails {
    private final Map<String, ThumbnailDetails> defaultThumbnail;
    private final Map<String, ThumbnailDetails> medium;
    private final Map<String, ThumbnailDetails> high;
}