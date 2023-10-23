package com.partymusicapp.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "party_user")
public class PartyJoin {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Party partyId;

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User userId;
}
