package com.partymusicapp.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @JoinColumn
    @OneToOne
    private Party hostedPartyId;

    @NonNull
    @Column
    private String username;

    @NonNull
    @Column
    private String email;

    @NonNull
    @Column
    private String password;

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

    @Column
    private boolean isEnabled;

    @Column
    private boolean isAccountNonExpired;

    @Column
    private boolean isCredentialsNonExpired;

    @Column
    private boolean isAccountNonLocked;

    @Column
    private String role;

    public User() {}
}
