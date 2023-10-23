package com.partymusicapp.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Follow")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @OneToOne
    @JoinColumn(name = "follower_id")
    private Follow followerID;

    @ManyToOne
    @JoinColumn(name = "followed ID")
    private Follow followedID;

    public Follow(){}

}
