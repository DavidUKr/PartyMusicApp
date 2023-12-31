package com.partymusicapp.Controllers;

import com.partymusicapp.security.model.AuthenticationResponse;
import com.partymusicapp.security.model.RegisterRequest;
import com.partymusicapp.security.service.AuthenticationService;
import com.partymusicapp.security.model.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pma/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationControllerImpl implements AuthenticationController{

    private final AuthenticationService authenticationService;

    @GetMapping(value = "/test_connection")
    public ResponseEntity<String> checkConnection() {
        return ResponseEntity.ok("Working connection and credentials! Great!");
    }


    @PostMapping(value = "/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }
}
