package com.partymusicapp.models.youtube;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
public class Item {
    private String kind;
    private String etag;
    private String id;
    private final Snippet snippet;
}
