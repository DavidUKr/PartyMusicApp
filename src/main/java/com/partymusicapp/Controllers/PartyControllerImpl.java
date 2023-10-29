package com.partymusicapp.Controllers;

import com.partymusicapp.models.dto.PartyDTO;
import com.partymusicapp.service.PartyService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

public class PartyControllerImpl {

    PartyService partyService;

    @GetMapping(value = "/{partyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    PartyDTO getParty(@PathVariable String partyId){
        return partyService.getPartyDTO(partyId);
    }

    @PostMapping(value = "/{partyId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateParty(@PathVariable String partyId, PartyDTO partyDTO){
        partyService.updateParty(partyId, partyDTO);
    }

    @DeleteMapping(value = "/{partyId}")
    void deleteParty(@PathVariable String partyId){
        partyService.deleteParty(partyId);
    }

    @PutMapping(value = "/save/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void savePartyTemplate(@PathVariable String userId, @RequestBody PartyDTO partyDTO){
        partyService.savePartyTemplate(userId, partyDTO);
    }
}
