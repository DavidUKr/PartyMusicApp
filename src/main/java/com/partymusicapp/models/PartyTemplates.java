package com.partymusicapp.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

@Entity
@Table(name = "PartyTemplates")
@Data
public class PartyTemplates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String tid;

    @OneToOne
    @JoinColumn(name = "User_ID")
    private User uid;

    @NonNull
    @Column
    private String mode;

    @NonNull
    @Column
    private int maxUsers;

    @NonNull
    @Column
    private boolean isPublic;


    public PartyTemplates(){}

}
