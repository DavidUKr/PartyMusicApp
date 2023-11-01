package com.partymusicapp.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface IdBasedUserDetailsService extends UserDetailsService {
    UserDetails loadUserByUserId(String userId);
}
