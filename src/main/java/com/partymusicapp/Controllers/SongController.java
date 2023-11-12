package com.partymusicapp.Controllers;

import com.partymusicapp.models.Song;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pma/api/v1/songs")
public interface SongController {

    @GetMapping(value = "/search/{search_input}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Song> search(@PathVariable String search_input);

    @PutMapping(value = "/{partyId}/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    Song addSong (@PathVariable String partyId, @RequestBody Song song, @RequestParam String userId);

    @GetMapping(value = "/{partyId}/songlist", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Song> getSongList(@PathVariable String partyId);

    @DeleteMapping(value = "/{partyId}/{songID}")
    void RemoveSong(@PathVariable String partyID, @PathVariable String songID);

    @GetMapping(value = "/{partyId}/{songId}", produces = MediaType.APPLICATION_JSON_VALUE)
    void voteSong(@PathVariable String partyID, @PathVariable String songId);

}
