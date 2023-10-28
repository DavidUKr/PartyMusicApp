package com.partymusicapp.repository;

import com.partymusicapp.models.PartyJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyJoinRepo extends JpaRepository<PartyJoin, String> {

}
