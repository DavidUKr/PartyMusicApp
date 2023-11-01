package com.partymusicapp.Controllers;

import com.partymusicapp.security.model.AuthenticationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "pma/api/v1/auth")
public interface AuthenticationController {

    @GetMapping(value = "/test_connection")
    String checkConnection ();


    ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest authenticationRequest);
}
