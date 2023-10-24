package com.partymusicapp.service;

import com.partymusicapp.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void registerUser(User user);
}
