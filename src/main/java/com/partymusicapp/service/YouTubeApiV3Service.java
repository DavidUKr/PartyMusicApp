package com.partymusicapp.service;

import com.partymusicapp.advice.exception.YoutubeSearchListEmptyException;
import com.partymusicapp.models.Song;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface YouTubeApiV3Service {

    List<Song> searchSong(String searchInput);

    Song getSongDetails(String SongId) throws YoutubeSearchListEmptyException;

    List<Song> getSongsDetails(List<String> songIds);
}
