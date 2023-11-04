package com.partymusicapp.Controllers;

import com.partymusicapp.models.Party;
import com.partymusicapp.models.Song;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.partymusicapp.service.SongService;
import java.util.List;

public class SongControllerImpl {

    SongService songService;

    @PutMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    Song addSong (@PathVariable String partyId, @RequestBody Song song){
        return songService.addSong(partyId, song);
    }

    @GetMapping(value = "/songlist", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Song> getSongList(@PathVariable Party partyId){
        return songService.getSongList(partyId);
    }

    @DeleteMapping(value = "/{songID}")
    void RemoveSong(@PathVariable Party partyID, String songID){
        songService.RemoveSong(partyID, songID);
    }

    @GetMapping(value = "/{partyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    void voteSong(@PathVariable Party partyID, String songID){
        songService.voteSong(partyID, songID);
    }
}
