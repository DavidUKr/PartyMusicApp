package com.partymusicapp.Controllers;

import com.partymusicapp.models.User;
import com.partymusicapp.models.dto.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pma/api/v1/users")
public interface UserController {

    @GetMapping(value = "/test")
    ResponseEntity<String> test();

    @GetMapping(value = "/userid/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserDTO getUser(@PathVariable String userId);

    @GetMapping(value = "/username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserDTO getUserByUsername(@PathVariable String username);

    @PostMapping(value = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateUser(@PathVariable String userId, @RequestBody UserDTO userDTO);

    @DeleteMapping(value = "/{userId}")
    void unregisterUser(@PathVariable String userId);

    @PostMapping(value = "/{userId}/grant")
    void grantRoleToUser(@PathVariable String userId);

    @PostMapping(value = "/{userId}/rating")
    void updateRating(@PathVariable String userId, @RequestParam int addedAmount);

}
