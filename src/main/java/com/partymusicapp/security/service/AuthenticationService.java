package com.partymusicapp.security.service;

import com.partymusicapp.security.model.AuthenticationRequest;
import com.partymusicapp.security.model.AuthenticationResponse;
import com.partymusicapp.security.model.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        return null;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        return null;
    }
}
