package com.partymusicapp.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
@Table(name = "songs")
@Builder
public class Song {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Party partyId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User suggesterId;

    @NonNull
    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String source;

    @Column
    private String thumbnail;

    @Column
    private int votes;

    public Song() {}
}
