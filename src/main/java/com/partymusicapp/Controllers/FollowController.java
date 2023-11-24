package com.partymusicapp.Controllers;

import com.partymusicapp.models.Follow;
import com.partymusicapp.models.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pma/api/v1/follow")
public interface FollowController {

    @PostMapping(value = "/addFollower", consumes = MediaType.APPLICATION_JSON_VALUE)
    Follow addFollow(@RequestParam String followerUsername, @RequestParam String followedUsername);


    @DeleteMapping(value ="/removeFollower/{followerUsername}")
    void removeFollower(@PathVariable User followerId);


    @GetMapping(value = "/showFollowers/{userId}")
    List<Follow> getAllFollowers(@PathVariable String userId);

}
