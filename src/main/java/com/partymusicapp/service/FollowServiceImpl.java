package com.partymusicapp.service;

import com.partymusicapp.advice.exception.FollowNotFoundException;
import com.partymusicapp.models.Follow;
import com.partymusicapp.models.User;
import com.partymusicapp.repository.FollowRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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
    public void deleteFollow(String followerUsername, String followedUsername) {
        followRepo.delete(getFollowByFollowerAndFollowedUsername(followerUsername, followedUsername));
    }

    @Override
    public List<Follow> getAllFollowersOfUsername(String username) {
        return followRepo.findAll().stream()
                .filter(follow -> follow.getFollowed().getUsername().equals(username))
                .toList();
    }

    @Override
    public Follow getFollowByFollowerAndFollowedUsername(String followerUsername, String followedUsername) {
        Optional<Follow> optionalFollow = followRepo.findFollowByFollowerAndFollowed(userService.getUserByUsername(followerUsername), userService.getUserByUsername(followedUsername));

        return optionalFollow.orElseThrow(()->new FollowNotFoundException("Follow by "+followerUsername+" to "+followedUsername+" not found"));
    }
}
