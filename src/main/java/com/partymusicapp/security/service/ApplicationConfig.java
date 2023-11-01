package com.partymusicapp.security.service;

import com.partymusicapp.advice.exception.UserNotFoundException;
import com.partymusicapp.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepo userRepo;

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> userRepo.findUserByUsername(username)
                .orElseThrow(()-> new UserNotFoundException("User with username: "+username+" not found."));
    }

}
