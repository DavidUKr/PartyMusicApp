package com.partymusicapp.service;

import com.partymusicapp.models.Song;
import com.partymusicapp.repository.SongRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService{

    private final YouTubeApiV3Service youTubeApiV3Service;
    private final SongRepo songRepo;
    private final UserService userService;
    private final PartyService partyService;

    @Override
    public List<Song> search(String searchInput) {

        return youTubeApiV3Service.searchSong(searchInput);
    }

    @Override
    public Song addSong(String partyId, Song song, String userId) {
        song.setSuggesterId(userService.getUserById(userId));
        song.setPartyId(partyService.getParty(partyId));
        song.setVotes(0);

        songRepo.save(song);

        return song;
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
