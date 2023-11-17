package com.partymusicapp.service;

import com.partymusicapp.models.Party;
import com.partymusicapp.models.dto.PartyDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PartyService {

    PartyDTO getPartyDTO(String partyId);

    void updateParty(String partyId, PartyDTO partyDTO);
  
    Party getParty(String partyId);

    void deleteParty(String partyId);

    void savePartyTemplate(String userId, PartyDTO partyDTO);

    void createParty(PartyDTO partyDTO);

    List<PartyDTO> getAllParties();

    long getPartyCount();
}
