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
    private User followerID;

    @ManyToOne
    @JoinColumn
    private User followedID;

    @Column
    private int noOfFollowers;

    public Follow(){}

}
