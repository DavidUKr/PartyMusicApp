package com.partymusicapp.Controllers;

import com.partymusicapp.models.Song;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.partymusicapp.service.SongService;
import java.util.List;

@RestController
@RequestMapping("/pma/api/v1/songs")
@RequiredArgsConstructor
public class SongControllerImpl{

    private final SongService songService;

    @GetMapping(value = "/search/{search_input}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Song> search(@PathVariable String search_input){
        return songService.search(search_input);
    }

    @PutMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    Song addSong (@PathVariable String partyId, @RequestBody Song song, @RequestParam String userId){
        return songService.addSong(partyId, song, userId);
    }

    @GetMapping(value = "/songlist", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Song> getSongList(@PathVariable String partyId){
        return songService.getSongList(partyId);
    }

    @DeleteMapping(value = "/{songID}")
    void RemoveSong(@PathVariable String partyID){
        songService.RemoveSong(partyID);
    }

    @GetMapping(value = "/partyId", produces = MediaType.APPLICATION_JSON_VALUE)
    void voteSong(@PathVariable String partyID){
        songService.voteSong(partyID);
    }
}
