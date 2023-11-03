package com.partymusicapp.models.mapper;

import com.partymusicapp.advice.exception.YoutubeSearchListEmptyException;
import com.partymusicapp.models.Song;
import com.partymusicapp.models.youtube.YouTubeSearchResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SongMapper {
    List<Song> youTubeSearchResponseToSongs (YouTubeSearchResponse youTubeSearchResponse);
    Song youTubeSearchResponseToSong (YouTubeSearchResponse youTubeSearchResponse) throws YoutubeSearchListEmptyException;
}
