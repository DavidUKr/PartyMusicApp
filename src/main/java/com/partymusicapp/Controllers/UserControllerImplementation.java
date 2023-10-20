package com.partymusicapp.Controllers;

import com.partymusicapp.models.User;
import com.partymusicapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "api/v1/users")
@RequiredArgsConstructor
public class UserControllerImplementation implements UserController{

    UserService userService;
    @Override
    @PutMapping(value="/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void registerUser(@RequestBody User user) {
        userService.registerUser(user);
    }
}
