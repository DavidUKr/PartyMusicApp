package com.partymusicapp.security;

import com.partymusicapp.advice.exception.UserNotFoundException;
import com.partymusicapp.models.User;
import com.partymusicapp.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IdBasedUserDetailsServiceImpl implements IdBasedUserDetailsService {

    private final UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return buildUserDetails(getUserByUserName(username)
                .orElseThrow(() -> new UserNotFoundException("User with username: "+ username + " not found.")));
    }

    public UserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        return buildUserDetails(getUserById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with userId: "+ userId + " not found.")));
    }

    private Optional<User> getUserByUserName(String username){
        return Optional.ofNullable(userRepo.findUserByUsername(username));
    }

    private Optional<User> getUserById(String userId){
        return Optional.ofNullable(userRepo.findUserById(userId));
    }

    private UserDetails buildUserDetails(User user){
        return new org.springframework.security.core.userdetails.User(
                String.valueOf(user.getId()),
                user.getPassword(),
                user.isEnabled(),
                user.isAccountNonExpired(),
                user.isCredentialsNonExpired(),
                user.isAccountNonLocked(),
                List.of(new SimpleGrantedAuthority(user.getRole()))
        );
    }
}
