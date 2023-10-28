package com.partymusicapp.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @NonNull
    @Column
    private String username;

    @NonNull
    @Column
    private String email;

    @NonNull
    @Column
    private String password;

    @NonNull
    @Column
    private SimpleGrantedAuthority role;

    @Column
    private String birthDate;

    @Column
    private int rating;

    @Column
    private int noOfSuggestedSongs;

    @Column
    private int noOfPlayedSongs;

    @Column
    private int noOfJoinedParties;

    @Column
    private int noOfHostedParties;

    public User() {}
}
