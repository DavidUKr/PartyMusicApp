package com.partymusicapp.service;

import com.partymusicapp.models.Song;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SongService {

    Song addSong(String partyId, Song song);

    List<Song> getSongList(String partyId);

    void RemoveSong(String partyID);

    void voteSong(String partyID);
}
