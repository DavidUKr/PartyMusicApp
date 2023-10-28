package com.partymusicapp.service;

import com.partymusicapp.models.Song;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService{
    @Override
    public void addSong(String partyId, Song song) {

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
