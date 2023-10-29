package com.partymusicapp.service;

import com.partymusicapp.models.dto.PartyDTO;
import org.springframework.stereotype.Service;

@Service
public interface PartyService {

    PartyDTO getPartyDTO(String partyId);

    void updateParty(String partyId, PartyDTO partyDTO);

    void deleteParty(String partyId);

    void savePartyTemplate(String userId, PartyDTO partyDTO);

}
