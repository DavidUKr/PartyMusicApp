package com.partymusicapp.repository;

import com.partymusicapp.models.Party;
import com.partymusicapp.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepo extends JpaRepository<Song, String> {
    Song findSongByIdAndPartyId(String songId, String partyId);

    List<Song> findByPartyId(String partyId);

}
