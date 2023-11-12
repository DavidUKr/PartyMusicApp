package com.partymusicapp.service;

import com.partymusicapp.models.Party;
import com.partymusicapp.models.Song;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SongService {

    List<Song> search(String searchInput);

    Song addSong(String partyId, Song song, String userId);

    List<Song> getSongList(Party partyId);

    void RemoveSong(Party partyId, String songId);

    void voteSong(Party partyID, String songId);
}
