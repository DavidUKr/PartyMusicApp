package com.partymusicapp.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import java.time.ZonedDateTime;

@Entity
@Data
@Table(name = "parties")
public class Party {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private String id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User ownerId;

    @Column
    private String ownerUsername;

    @NonNull
    @Column
    private String mode;

    @Column
    private ZonedDateTime startTime;

    @Column
    private ZonedDateTime endTime;

    @Column
    private int maxUsers;

    @Column
    private boolean isPublic;

    @Column
    private String backgroundImageURL;

    @Column
    private String iconURL;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Theme themeId;

   @Column
    private String title;

    public Party() {}
}
