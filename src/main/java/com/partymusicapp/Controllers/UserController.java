package com.partymusicapp.Controllers;

import com.partymusicapp.models.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "pma/api/v1/users")
public interface UserController {

    @PutMapping(value = "/register")
    void registerUser(User user);

    /*@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserDTO getUser(@PathVariable String id);*/

   /* @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateUser(@PathVariable String id, @RequestBody UserDTO userDTO);*/

    @DeleteMapping(value = "/{id}")
    void unregisterUser(@PathVariable String id);

    @PostMapping(value = "/{id}/grant")
    void grantRoleToUser(@PathVariable String id);

}
