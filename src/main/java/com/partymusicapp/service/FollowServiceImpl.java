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
    public Follow addFollow(String followerUsername, String followedUsername) {
        Follow follow = new Follow();
        User followed=userService.getUserByUsername(followedUsername);
        follow.setFollower(userService.getUserByUsername(followerUsername));
        follow.setFollowed(followed);

        followed.setNoOfFollowers(followed.getNoOfFollowers()+1);
        userService.updateUser(followed);

        followRepo.save(follow);

        return follow;
    }

    @Override
    public void deleteFollower(User followerId) {
        Follow follower = followRepo.findFollowByFollower(followerId);
        if(follower != null)
            followRepo.delete(follower);
    }

    @Override
    public List<Follow> getAllFollowers() {
        return followRepo.findAll().stream()
                .toList();
    }
}
