package com.partymusicapp.security.service;

import com.partymusicapp.advice.exception.UserNotFoundException;
import com.partymusicapp.models.Role;
import com.partymusicapp.models.User;
import com.partymusicapp.service.UserServiceImpl;
import com.partymusicapp.repository.UserRepo;
import com.partymusicapp.security.model.AuthenticationRequest;
import com.partymusicapp.security.model.AuthenticationResponse;
import com.partymusicapp.security.model.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user= User.builder()
                .username(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();

        userRepo.save(user);

        var jwtToken=jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        var user= userRepo.findUserByUsername(authenticationRequest.getUsername())
                .orElseThrow(()-> new UserNotFoundException("User "+authenticationRequest.getUsername()+" not found"));


        var jwtToken=jwtService.generateToken(user);


        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


}
