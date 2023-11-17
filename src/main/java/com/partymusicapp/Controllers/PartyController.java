package com.partymusicapp.Controllers;

import com.partymusicapp.models.dto.PartyDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pma/api/v1/parties")
public interface PartyController {

    @PutMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    void createParty(@RequestBody PartyDTO partyDTO);

    @GetMapping(value = "/{partyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    PartyDTO getParty(@PathVariable String partyId);

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<PartyDTO> getAllParties();

    @GetMapping(value = "/all/count", produces = MediaType.APPLICATION_JSON_VALUE)
    long getPartyCount();

    @PostMapping(value = "/{partyId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateParty(@PathVariable String partyId, @RequestBody PartyDTO partyDTO);

    @DeleteMapping(value = "/{partyId}")
    void deleteParty(@PathVariable String partyId);

    @PutMapping(value = "/save/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void savePartyTemplate(@PathVariable String userId, @RequestBody PartyDTO partyDTO);

}
