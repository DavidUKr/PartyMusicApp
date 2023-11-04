package com.partymusicapp.models.youtube;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Data
@RequiredArgsConstructor
public class ThumbnailDetails {
    private String url;
    private int width;
    private int height;
}