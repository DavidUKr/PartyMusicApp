package com.partymusicapp.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "party_user")
public class PartyJoin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Party partyId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User userId;
}
