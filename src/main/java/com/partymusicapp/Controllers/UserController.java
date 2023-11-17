package com.partymusicapp.Controllers;

import com.partymusicapp.models.Role;
import com.partymusicapp.models.dto.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pma/api/v1/users")
public interface UserController {

    @GetMapping(value = "/test")
    ResponseEntity<String> test();

    @GetMapping(value = "/userid/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserDTO getUser(@PathVariable String userId);

    @GetMapping(value = "/username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserDTO getUserByUsername(@PathVariable String username);

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDTO> getAllUsers();

    @GetMapping(value = "/all/count", produces = MediaType.APPLICATION_JSON_VALUE)
    long getUserCount();

    @PostMapping(value = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateUser(@PathVariable String userId, @RequestBody UserDTO userDTO);

    @DeleteMapping(value = "/{userId}")
    void unregisterUser(@PathVariable String userId);

    @PostMapping(value = "/{userId}/grant")
    void grantRoleToUserId(@PathVariable String userId, @RequestParam Role role);

    @PostMapping(value = "/{userId}/rating")
    void updateRating(@PathVariable String userId, @RequestParam int addedAmount);

}
