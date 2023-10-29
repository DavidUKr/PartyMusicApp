package com.partymusicapp.service;

import com.partymusicapp.models.Song;
import com.partymusicapp.repository.SongRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService{

    SongRepo songRepo;
    @Override
    public Song addSong(String partyId, Song song) {
        return null; //TODO implement use of the YouTube v3 API to get Song Info
    }

    @Override
    public List<Song> getSongList(String partyId) {
        return songRepo.findByPartyId(partyId);
    }

    @Override
    public void RemoveSong(String partyId, String songId) {
        Song songToRemove = songRepo.findSongByIdAndPartyId(songId, partyId);
         if (songToRemove != null) {
             songRepo.delete(songToRemove);
         }
    }

    @Override
    public void voteSong(String partyId, String songId) {
//        Song songToVote = songRepo.findSongByIdAndPartyId(songId, partyId);
//         if (songToVote != null) {
//             songToVote.incrementVotes(); // Implement a method to update the votes.
//             songRepo.save(songToVote);
    }
}
