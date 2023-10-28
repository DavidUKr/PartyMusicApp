package com.partymusicapp.Controllers;

import com.partymusicapp.models.Song;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pma/api/v1/songs/{partyId}")
public interface SongController {

    @PutMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    void addSong (@PathVariable String partyId, @RequestBody Song song);

    @GetMapping(value = "/songlist", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Song> getSongList(@PathVariable String partyId);

    @DeleteMapping(value = "/{songID}")
    void RemoveSong(@PathVariable String partyID);

    @GetMapping(value = "/{partyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    void voteSong(@PathVariable String partyID);

}
