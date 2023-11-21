package com.partymusicapp.service;


import com.partymusicapp.models.Follow;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FollowService {
    Follow addFollower(String followerId, String followedId);

    void deleteFollower(String followerId);

    List<Follow> getAllFollowers();
}
