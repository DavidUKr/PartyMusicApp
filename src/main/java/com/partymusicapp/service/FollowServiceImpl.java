package com.partymusicapp.service;

import com.partymusicapp.models.Follow;
import com.partymusicapp.models.User;
import com.partymusicapp.repository.FollowRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService{

    private final FollowRepo followRepo;

    @Override
    public Follow addFollower(User followerId, User followedId) {


        Follow follow = new Follow();
        follow.setFollowerID(followerId);
        follow.setFollowedID(followedId);

        followedId.setNoOfFollowers(followedId.getNoOfFollowers() + 1);

        followRepo.save(follow);

        return follow;
    }

    @Override
    public void deleteFollower(User followerId) {
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
