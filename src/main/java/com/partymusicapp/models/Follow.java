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
    private User follower;

    @ManyToOne
    @JoinColumn
    private User followed;

    @Column
    private int noOfFollowers;

    public Follow(){}

}
