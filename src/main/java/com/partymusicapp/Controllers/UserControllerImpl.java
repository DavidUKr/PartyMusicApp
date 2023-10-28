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

    private final UserService userService;
//TODO add OPENAPI documentation
    @PutMapping(value = "/register")
    public void registerUser(@RequestBody User user) {
        userService.registerUser(user);
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getUser(@PathVariable String userId) {
        return userService.getUserDTO(userId);
    }

    @PostMapping(value = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@PathVariable String userId, UserDTO userDTO) {
        userService.updateUser(userId, userDTO);
    }

    @DeleteMapping(value = "/{userId}")
    public void unregisterUser(@PathVariable String userId) {
        userService.unregisterUser(userId);
    }

    @PostMapping(value = "/{userId}/grant")
    public void grantRoleToUser(@PathVariable String userId) {
        userService.grantRoleToUser(userId);
    }

    @PostMapping(value = "/{userId}/rating")
    public void updateRating(@PathVariable String userId, @RequestParam int addedAmount) {
        userService.updateRating(userId, addedAmount);
    }
}
