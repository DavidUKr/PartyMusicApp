package com.partymusicapp.service;

import com.partymusicapp.models.Follow;
import com.partymusicapp.repository.FollowRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService{

    private final FollowRepo followRepo;
    private final UserService userService;

    @Override
    public void addFollower(String followerId, String followedId) {

        followRepo.save()
    }

    @Override
    public void deleteFollower(String followerId) {
        Follow follower = followRepo.findFollowerByFollowerId(followerId);
        if(follower != null)
            followRepo.delete(follower);
    }

    @Override
    public List<Follow> getAllFollowers() {
        return followRepo.findAll().stream()
                .toList();
    }
}
