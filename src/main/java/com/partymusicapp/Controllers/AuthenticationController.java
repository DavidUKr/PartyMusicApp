package com.partymusicapp.Controllers;

import com.partymusicapp.security.model.AuthenticationRequest;
import com.partymusicapp.security.model.AuthenticationResponse;
import com.partymusicapp.security.model.RegisterRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "pma/api/v1/auth")
public interface AuthenticationController {

    @GetMapping(value = "/test_connection")
    String checkConnection ();

    @PostMapping(value = "/register")
    ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest);

    @PostMapping(value = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest);
}
