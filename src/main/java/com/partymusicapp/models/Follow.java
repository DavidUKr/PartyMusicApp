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
    private Follow followerID;

    @ManyToOne
    @JoinColumn
    private Follow followedID;

    @Column
    private int noOfFollowers;

    public Follow(){}

}
