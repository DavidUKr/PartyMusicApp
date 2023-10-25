package com.partymusicapp.service;

import com.partymusicapp.models.dto.PartyDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface PartyService {

    PartyDTO getParty(String partyId);

    void updateParty(@PathVariable String partyId);

    void deleteParty(@PathVariable String partyId);

    void savePartyTemplate(@PathVariable String userId, @RequestBody PartyDTO partyDTO);

    void getInfo(@PathVariable String partyID);
}
