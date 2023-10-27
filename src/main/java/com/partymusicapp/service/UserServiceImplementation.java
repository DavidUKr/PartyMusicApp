package com.partymusicapp.service;

import com.partymusicapp.advice.exception.UserNotFoundException;
import com.partymusicapp.models.User;
import com.partymusicapp.models.dto.UserDTO;
import com.partymusicapp.models.mapper.UserMapper;
import com.partymusicapp.repository.UserRepo;
import com.partymusicapp.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService{

    UserRepo userRepo;
    UserMapper userMapper;
    UserUtil userUtil;
    @Override
    public void registerUser(User user) {
        userRepo.save(user);
    }

    @Override
    public User getUser(String userId) {
        return getUserFromUserRepoById(userId).orElseThrow(()->new UserNotFoundException("User with Id "+userId+"not found"));
    }

    @Override
    public UserDTO getUserDTO(String userId) throws UserNotFoundException{
        return userMapper.userToUserDTO(getUser(userId));
    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {
        User user=userUtil.getUpdatedUserBasedOnDTO(getUser(userId), userDTO);
        userRepo.save(user);
    }

    @Override
    public void unregisterUser(String userId) {
        userRepo.delete(userRepo.findUserById(userId));
    }

    @Override
    public void grantRoleToUser(String userId) {
        //TODO implement party leader/ attendee system - token stuff
    }

    @Override
    public void updateRating(String userId, int addedAmount) {
        UserDTO userDTO=new UserDTO();
        userDTO.setRating(getUser(userId).getRating()+addedAmount);
        updateUser(userId, userDTO);
    }

    private Optional<User> getUserFromUserRepoById(String userId) throws UserNotFoundException{
        return Optional.ofNullable(userRepo.findUserById(userId));
    }
}
