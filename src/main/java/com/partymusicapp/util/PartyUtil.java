package com.partymusicapp.util;

import com.partymusicapp.models.Party;
import com.partymusicapp.models.dto.PartyDTO;

public class PartyUtil {

    public Party getUpdatedPartyBasedOnDTO(Party party, PartyDTO partyDTO){
        if(partyDTO.getMode() != null) party.setMode(partyDTO.getMode());
        if(partyDTO.getStartTime() != null) party.setStartTime(partyDTO.getStartTime());
        if(partyDTO.getEndTime() != null) party.setEndTime(partyDTO.getEndTime());
        party.setPublic(partyDTO.isPublic());
        if(partyDTO.getIconURL() != null) party.setIconURL(partyDTO.getIconURL());

        return party;
    }
}
