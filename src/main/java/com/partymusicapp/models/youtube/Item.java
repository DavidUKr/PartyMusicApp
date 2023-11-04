package com.partymusicapp.models.youtube;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@RequiredArgsConstructor
public class Item {
    private String kind;
    private String etag;
    private Id id;
    private Snippet snippet;
}
