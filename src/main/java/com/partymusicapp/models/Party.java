package com.partymusicapp.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.net.URL;
import java.time.ZonedDateTime;

@Entity
@Data
@Table(name = "parties")
public class Party {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private String id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User ownerID;

    @NonNull
    @Column
    private String mode;

    @NonNull
    @Column
    private ZonedDateTime startTime;

    @NonNull
    @Column
    private ZonedDateTime endTime;

    @Column
    private int maxUsers;

    @Column
    private boolean isPublic;

    @Column
    private URL backgroundImage;

    @Column
    private URL icon;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    @Column Theme theme;

    public Party() {}
}
