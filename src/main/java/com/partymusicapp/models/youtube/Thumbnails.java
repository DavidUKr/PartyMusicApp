package com.partymusicapp.models.youtube;

import lombok.Data;

import java.util.Map;

@Data
public class Thumbnails {
    private Map<String, YouTubeVideo.ThumbnailDetails> defaultThumbnail;
    private Map<String, YouTubeVideo.ThumbnailDetails> medium;
    private Map<String, YouTubeVideo.ThumbnailDetails> high;
}