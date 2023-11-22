package com.partymusicapp.service;


import com.partymusicapp.models.Follow;
import com.partymusicapp.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FollowService {
    Follow addFollower(User followerId, User followedId);

    void deleteFollower(User followerId);

    List<Follow> getAllFollowers();
}
