package com.partymusicapp.service;

import com.partymusicapp.models.dto.PartyDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface PartyService {

    PartyDTO getParty(String partyId);

    void updateParty(String partyId);

    void deleteParty(String partyId);

    void savePartyTemplate(String userId, PartyDTO partyDTO);

    void getInfo(String partyID);
}
