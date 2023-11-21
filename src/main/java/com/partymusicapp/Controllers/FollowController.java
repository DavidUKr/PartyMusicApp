package com.partymusicapp.Controllers;

import com.partymusicapp.models.Follow;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pma/api/v1/follow")
public interface FollowController {

    @PostMapping(value = "/addFollower", consumes = MediaType.APPLICATION_JSON_VALUE)
    Follow addFollower(@PathVariable String followedId, @PathVariable String followerId);


    @DeleteMapping(value ="/removeFollower/{followerId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> removeFollower(@PathVariable String followerId);


    @GetMapping(value = "/showFollowers/{userId}")
    List<Follow> getAllFollowers(@PathVariable String userId);

}
