package com.partymusicapp.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "pma/api/v1/auth")
public class AuthenticationControllerImpl implements AuthenticationController{

    @GetMapping(value = "/test_connection")
    public String checkConnection() {
        return "Working connection and credentials! Great!";
    }
}
