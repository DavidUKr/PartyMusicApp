package com.partymusicapp.service;

import com.partymusicapp.models.Role;
import com.partymusicapp.models.User;
import com.partymusicapp.models.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserDTO getUserDTOById(String userId);
    UserDTO getUserDTOByUsername(String username);

    User getUserById(String userId);
    User getUserByUsername(String username);

    void updateUser(String userId, UserDTO userDTO);
    void updateUser(User user);

    void unregisterUser(String userId);

    void grantRoleToUserId(String userId, Role role);

    void grantRoleToUsername(String username, Role role);

    void updateRating(String userId, int addedAmmount);

    List<UserDTO> getAllUsers();
}
