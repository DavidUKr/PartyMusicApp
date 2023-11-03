package com.partymusicapp.models.youtube;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
public class YouTubeSearchResponse {

    private String kind;
    private String etag;
    private final Item[] items;
}
