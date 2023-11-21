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
    private final UserService userService;

    @Override
    public void addFollower(String followerId, String followedId) {
        User follower = userService.getUserById(followerId);
        User followed = userService.getUserById(followedId);

        Follow follow = new Follow();
        follow.setFollowerID(follower.getId());
        follow.setFollowedID(followed.getId());

        followed.setNoOfFollowers(followed.getNoOfFollowers() + 1);


        followRepo.save(follow);
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
