package com.partymusicapp.Controllers;

import com.partymusicapp.models.Follow;
import com.partymusicapp.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pma/api/v1/follow")
@RequiredArgsConstructor
public class FollowControllerImpl implements FollowController{

    private final FollowService followService;

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Follow addFollow(@RequestParam String followerUsername, @RequestParam String followedUsername) {
        return followService.addFollow(followerUsername, followedUsername);
    }


    @DeleteMapping(value ="/remove")
    public void removeFollow(@RequestParam String followerUsername, @RequestParam String followedUsername) {
        followService.deleteFollow(followerUsername, followedUsername);
    }

    @Override
    public List<Follow> getAllFollowersOfUsername(String username) {
        return followService.getAllFollowersOfUsername(username);
    }
}
