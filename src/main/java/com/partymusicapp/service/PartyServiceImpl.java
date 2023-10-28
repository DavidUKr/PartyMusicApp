package com.partymusicapp.service;

import com.partymusicapp.advice.exception.PartyNotFoundException;
import com.partymusicapp.models.Party;
import com.partymusicapp.models.dto.PartyDTO;
import com.partymusicapp.models.mapper.PartyMapper;
import com.partymusicapp.repository.PartyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartyServiceImpl implements PartyService{

    PartyRepo partyRepo;
    PartyMapper partyMapper;

    public Party getParty(String partyId){
        return getPartyOptionalById(partyId).orElseThrow(() -> new PartyNotFoundException("Party with Id "+partyId+" not found."));
    }

    @Override
    public PartyDTO getPartyDTO(String partyId) {
        return partyMapper.partyToPartyDTO(getParty(partyId));
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

    private Optional<Party> getPartyOptionalById(String partyId) {
        return Optional.ofNullable(partyRepo.findPartyById(partyId));
    }
}
