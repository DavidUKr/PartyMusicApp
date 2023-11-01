package com.partymusicapp.Controllers;

import com.partymusicapp.security.service.IdBasedUserDetailsService;
import com.partymusicapp.security.util.JwtUtil;
import com.partymusicapp.security.model.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "pma/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationControllerImpl implements AuthenticationController{

    private final AuthenticationManager authenticationManager;
    private final IdBasedUserDetailsService idBasedUserDetailsService;
    private final JwtUtil jwtUtil;

    @GetMapping(value = "/test_connection")
    public String checkConnection() {
        return "Working connection and credentials! Great!";
    }

    @PostMapping(value = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(authenticationRequest.getId(), authenticationRequest.getPassword()));
        final UserDetails user= idBasedUserDetailsService.loadUserByUserId(authenticationRequest.getId());

        if(user!=null){
            return ResponseEntity.ok(jwtUtil.generateToken(user));
        }

        return ResponseEntity.status(400).body("Could not authenticate user with id:"+authenticationRequest.getId());
    }
}
