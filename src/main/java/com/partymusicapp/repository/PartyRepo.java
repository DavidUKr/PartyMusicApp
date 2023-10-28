package com.partymusicapp.repository;

import com.partymusicapp.models.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepo extends JpaRepository<Party, String> {
    Party findPartyById(String partyId);
}
