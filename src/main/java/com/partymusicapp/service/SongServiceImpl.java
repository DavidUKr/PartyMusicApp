package com.partymusicapp.service;

import com.partymusicapp.models.Party;
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
    public List<Song> getSongList(Party partyId) {
        return songRepo.findByPartyId(partyId);
    }

    @Override
    public void RemoveSong(Party partyId, String songId) {
        Song songToRemove = songRepo.findSongByIdAndPartyId(songId, partyId);
         if (songToRemove != null) {
             songRepo.delete(songToRemove);
         }
    }

    @Override
    public void voteSong(Party partyId, String songId) {
//        Song songToVote = songRepo.findSongByIdAndPartyId(songId, partyId);
//         if (songToVote != null) {
//             songToVote.incrementVotes(); // Implement a method to update the votes.
//             songRepo.save(songToVote);
    }
}
