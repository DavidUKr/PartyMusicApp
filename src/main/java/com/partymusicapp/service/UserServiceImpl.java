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
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final UserUtil userUtil;

    @Override
    public User getUserById(String userId) {
        return getUserFromUserRepoById(userId).orElseThrow(()->new UserNotFoundException("User with Id "+userId+" not found"));
    }

    @Override
    public User getUserByUsername(String username) {
        return getUserFromUserRepoByUsername(username).orElseThrow(()->new UserNotFoundException("User with username "+username+" not found"));
    }

    @Override
    public UserDTO getUserDTOById(String userId) throws UserNotFoundException{
        return userMapper.userToUserDTO(getUserById(userId));
    }

    @Override
    public UserDTO getUserDTOByUsername(String username) {
        return userMapper.userToUserDTO(getUserByUsername(username));
    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {
        User user=userUtil.getUpdatedUserBasedOnDTO(getUserById(userId), userDTO);
        userRepo.save(user);
    }

    @Override
    public void unregisterUser(String userId) {
        userRepo.delete(getUserById(userId));
    }

    @Override
    public void grantRoleToUser(String userId) {
        //TODO implement party leader/ attendee system - token stuff
    }

    @Override
    public void updateRating(String userId, int addedAmount) {
        UserDTO userDTO=new UserDTO();
        userDTO.setRating(getUserById(userId).getRating()+addedAmount);
        updateUser(userId, userDTO);
    }

    private Optional<User> getUserFromUserRepoById(String userId) throws UserNotFoundException{
        return userRepo.findUserById(userId);
    }

    private Optional<User> getUserFromUserRepoByUsername(String username) {
        return userRepo.findUserByUsername(username);
    }
}