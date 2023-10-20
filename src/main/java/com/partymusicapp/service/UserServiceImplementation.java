package com.partymusicapp.service;

import com.partymusicapp.models.User;
import com.partymusicapp.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService{

    UserRepo userRepo;
    @Override
    public void registerUser(User user) {
        userRepo.save(user);
    }
}
