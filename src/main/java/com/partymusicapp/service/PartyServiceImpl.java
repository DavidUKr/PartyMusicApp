package com.partymusicapp.service;

import com.partymusicapp.models.Party;
import com.partymusicapp.models.dto.PartyDTO;
import org.springframework.stereotype.Service;

@Service
public class PartyServiceImpl implements PartyService{

    public Party getParty(String partyId){
        return null;
    }

    @Override
    public PartyDTO getPartyDTO(String partyId) {
        return null;
    }

    @Override
    public void updateParty(String partyId) {

    }

    @Override
    public void deleteParty(String partyId) {

    }

    @Override
    public void savePartyTemplate(String userId, PartyDTO partyDTO) {

    }

    @Override
    public void getInfo(String partyID) {

    }
}
