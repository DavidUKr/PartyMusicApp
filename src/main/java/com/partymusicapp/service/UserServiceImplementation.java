package com.partymusicapp.service;

import com.partymusicapp.advice.exception.UserNotFoundException;
import com.partymusicapp.models.User;
import com.partymusicapp.models.dto.UserDTO;
import com.partymusicapp.models.mapper.UserMapper;
import com.partymusicapp.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService{

    UserRepo userRepo;
    UserMapper userMapper;
    @Override
    public void registerUser(User user) {
        userRepo.save(user);
    }

    @Override
    public UserDTO getUser(String userId) throws UserNotFoundException{
        Optional<User> userOptional;
        userOptional=Optional.of(userRepo.findUserById(userId));

        if(userOptional.isPresent()){
            return userMapper.userToUserDTO(userOptional.get());
        }
        else throw new UserNotFoundException("User id not found");
    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {

    }

    @Override
    public void unregisterUser(String userId) {
        userRepo.delete(userRepo.findUserById(userId));
    }

    @Override
    public void grantRoleToUser(String userId) {

    }

    @Override
    public void updateRating(String userId, int amount) {

    }
}
