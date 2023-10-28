package com.partymusicapp.repository;

import com.partymusicapp.models.Party;
import com.partymusicapp.models.PartyJoin;
import com.partymusicapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PartyJoinRepo extends JpaRepository<PartyJoin, String> {

    PartyJoin findPartyJoinById(String partyJoinId);
    PartyJoin findPartyJoinByUserId(User user);
    List<PartyJoin> findPartyJoinsByPartyId(Party party);

}
