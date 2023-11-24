package com.partymusicapp.service;


import com.partymusicapp.models.Follow;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FollowService {
    Follow addFollow(String followerUsername, String followedUsername);

    void deleteFollow(String followerUsername, String followedUsername);

    List<Follow> getAllFollowersOfUsername(String Username);

    Follow getFollowByFollowerAndFollowedUsername(String followerUsername, String followedUsername);

}
