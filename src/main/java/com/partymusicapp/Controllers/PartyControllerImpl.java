package com.partymusicapp.Controllers;

import com.partymusicapp.models.dto.PartyDTO;
import com.partymusicapp.service.PartyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pma/api/v1/parties")
@RequiredArgsConstructor
public class PartyControllerImpl implements PartyController{

    private final PartyService partyService;

    @PutMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createParty(@RequestBody PartyDTO partyDTO) {
        partyService.createParty(partyDTO);
    }

    @GetMapping(value = "/{partyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PartyDTO getParty(@PathVariable String partyId){
        return partyService.getPartyDTO(partyId);
    }

    @Override
    public List<PartyDTO> getAllParties() {
        return partyService.getAllParties();
    }

    @PostMapping(value = "/{partyId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateParty(@PathVariable String partyId, @RequestBody PartyDTO partyDTO){
        partyService.updateParty(partyId, partyDTO);
    }

    @DeleteMapping(value = "/{partyId}")
    public void deleteParty(@PathVariable String partyId){
        partyService.deleteParty(partyId);
    }

    @PutMapping(value = "/save/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void savePartyTemplate(@PathVariable String userId, @RequestBody PartyDTO partyDTO){
        partyService.savePartyTemplate(userId, partyDTO);
    }
}
