package com.partymusicapp.Controllers;

import com.partymusicapp.models.Follow;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pma/api/v1/follow")
public interface FollowController {

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    Follow addFollow(@RequestParam String followerUsername, @RequestParam String followedUsername);


    @DeleteMapping(value ="/remove")
    void removeFollow(@RequestParam String followerUsername, @RequestParam String followedUsername);


    @GetMapping(value = "/showFollowers/{username}")
    List<Follow> getAllFollowersOfUsername(@PathVariable String username);

}
