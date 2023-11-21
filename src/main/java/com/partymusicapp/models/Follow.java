package com.partymusicapp.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Follow")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn
    private String followerID;

    @ManyToOne
    @JoinColumn
    private String followedID;

    @Column
    private int noOfFollowers;

    public Follow(){}

}
