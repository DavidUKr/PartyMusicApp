package com.partymusicapp.models.youtube;

import lombok.*;

import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class YouTubeSearchResponse {

    private String kind;
    private String etag;
    private Item[] items;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Item {
        private String kind;
        private String etag;
        private Id id;
        private Snippet snippet;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Id {
        private String kind;
        private String videoId;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Snippet {
        private String channelId;
        private String channelTitle;
        private String title;
        private Thumbnails thumbnails;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Thumbnails {
        private ThumbnailDetails defaultThumbnail;
        private ThumbnailDetails medium;
        private ThumbnailDetails high;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ThumbnailDetails {
        private String url;
        private int width;
        private int height;
    }
}
