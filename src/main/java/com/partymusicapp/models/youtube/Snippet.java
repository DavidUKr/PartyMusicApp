package com.partymusicapp.models.youtube;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
public class Snippet {
    private String channelId;
    private String channelTitle;
    private String title;
    private final Thumbnails thumbnails;
}