package com.partymusicapp.service;

import com.partymusicapp.models.User;
import com.partymusicapp.models.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDTO getUserDTOById(String userId);
    UserDTO getUserDTOByUsername(String username);

    User getUserById(String userId);
    User getUserByUsername(String username);

    void updateUser(String userId, UserDTO userDTO);

    void unregisterUser(String userId);

    void grantRoleToUser(String userId);

    void updateRating(String userId, int addedAmmount);
}
