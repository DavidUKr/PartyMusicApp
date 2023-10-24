package com.partymusicapp.Controllers;

import com.partymusicapp.models.User;
import com.partymusicapp.models.dto.UserDTO;
import com.partymusicapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "pma/api/v1/users")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController{

    UserService userService;
//TODO add OPENAPI documentation
    @PutMapping(value = "/register")
    public void registerUser(User user) {
        userService.registerUser(user);
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getUser(String userId) {
        return userService.getUser(userId);
    }

    @PostMapping(value = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(String userId, UserDTO userDTO) {
        userService.updateUser(userId, userDTO);
    }

    @DeleteMapping(value = "/{userId}")
    public void unregisterUser(String userId) {
        userService.unregisterUser(userId);
    }

    @PostMapping(value = "/{userId}/grant")
    public void grantRoleToUser(String userId) {
        userService.grantRoleToUser(userId);
    }

    @PostMapping(value = "/{userId}/rating")
    public void updateRating(String userId, int amount) {
        userService.updateRating(userId, amount);
    }
}
