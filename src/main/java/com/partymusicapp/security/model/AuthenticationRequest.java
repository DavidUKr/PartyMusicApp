package com.partymusicapp.security.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class AuthenticationRequest {
    private String id;
    private String password;
}
