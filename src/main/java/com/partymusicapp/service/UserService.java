package com.partymusicapp.service;

import com.partymusicapp.models.User;
import com.partymusicapp.models.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDTO getUserDTO(String userId);
    User getUser(String userId);

    void updateUser(String userId, UserDTO userDTO);

    void unregisterUser(String userId);

    void grantRoleToUser(String userId);

    void updateRating(String userId, int addedAmmount);
}
