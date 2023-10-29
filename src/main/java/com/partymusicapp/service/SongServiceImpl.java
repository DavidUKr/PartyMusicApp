package com.partymusicapp.service;

import com.partymusicapp.models.Song;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService{
    @Override
    public Song addSong(String partyId, Song song) {
        return null; //TODO implement use of the YouTube v3 API to get Song Info
    }

    @Override
    public List<Song> getSongList(String partyId) {
        return null;
    }

    @Override
    public void RemoveSong(String partyID) {

    }

    @Override
    public void voteSong(String partyID) {

    }
}
