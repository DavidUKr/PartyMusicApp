package com.partymusicapp.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.net.URL;

@Entity
@Data
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private URL source;

    @Column
    private int votes;

    public Song() {}
}
