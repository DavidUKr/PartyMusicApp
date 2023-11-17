package com.partymusicapp.Controllers;

import com.partymusicapp.models.Role;
import com.partymusicapp.models.dto.UserDTO;
import com.partymusicapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pma/api/v1/users")
@RequiredArgsConstructor

public class UserControllerImpl implements UserController{

    private final UserService userService;
//TODO add OPENAPI documentation

    @GetMapping(value = "/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("You have acccess to user controller");
    }

    @GetMapping(value = "/userid/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getUser(@PathVariable String userId) {
        return userService.getUserDTOById(userId);
    }

    @GetMapping(value = "/username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getUserByUsername(@PathVariable String username) {
        return userService.getUserDTOByUsername(username);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
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
    public void grantRoleToUserId(@PathVariable String userId, @RequestParam Role role) {
        userService.grantRoleToUserId(userId, role);
    }

    @PostMapping(value = "/{userId}/rating")
    public void updateRating(@PathVariable String userId, @RequestParam int addedAmount) {
        userService.updateRating(userId, addedAmount);
    }
}
