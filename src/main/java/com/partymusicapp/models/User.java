package com.partymusicapp.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {

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
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
