package com.partymusicapp.service;

import com.partymusicapp.advice.exception.PartyNotFoundException;
import com.partymusicapp.models.Party;
import com.partymusicapp.models.Role;
import com.partymusicapp.models.User;
import com.partymusicapp.models.dto.PartyDTO;
import com.partymusicapp.models.mapper.PartyMapper;
import com.partymusicapp.repository.PartyRepo;
import com.partymusicapp.util.PartyUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartyServiceImpl implements PartyService{

    private final PartyRepo partyRepo;
    private final PartyMapper partyMapper;
    private final UserService userService;

    PartyUtil partyUtil;

    public Party getParty(String partyId){
        return getPartyOptionalById(partyId).orElseThrow(() -> new PartyNotFoundException("Party with Id "+partyId+" not found."));
    }

    @Override
    public PartyDTO getPartyDTO(String partyId) {
        return partyMapper.partyToPartyDTO(getParty(partyId));
    }

    @Override
    public void updateParty(String partyId, PartyDTO partyDTO) {
        Party party = partyUtil.getUpdatedPartyBasedOnDTO(getParty(partyId), partyDTO);
        partyRepo.save(party);
    }

    @Override
    public void deleteParty(String partyId) {
        Party party=partyRepo.findPartyById(partyId);
        partyRepo.delete(party);
        userService.grantRoleToUsername(party.getOwnerUsername(), Role.USER);
    }

    @Override
    public void savePartyTemplate(String userId, PartyDTO partyDTO) {
        Party party = partyMapper.partyDTOToParty(partyDTO);
        partyRepo.save(party);
    }

    @Override
    public void createParty(PartyDTO partyDTO) {
        partyRepo.save(partyMapper.partyDTOToParty(partyDTO));
        userService.grantRoleToUsername(partyDTO.getOwnerUsername(), Role.PARTY_OWNER);
    }

    @Override
    public List<PartyDTO> getAllParties() {
        return partyRepo.findAll().stream()
                .map(partyMapper::partyToPartyDTO)
                .toList();
    }

    @Override
    public long getPartyCount() {
        return partyRepo.count();
    }

    private Optional<Party> getPartyOptionalById(String partyId) {
        return Optional.ofNullable(partyRepo.findPartyById(partyId));
    }
}
