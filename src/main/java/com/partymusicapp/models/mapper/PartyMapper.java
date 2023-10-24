package com.partymusicapp.models.mapper;
import com.partymusicapp.models.Party;
import com.partymusicapp.models.dto.PartyDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PartyMapper {

    PartyDTO partyToPartyDTO(Party party);

    Party partyDTOToParty(PartyDTO partyDTO);

    List<PartyDTO> partiesToPartyDTOs(List<Party> parties);
}
