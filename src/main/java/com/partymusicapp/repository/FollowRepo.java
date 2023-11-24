package com.partymusicapp.repository;

import com.partymusicapp.models.Follow;
import com.partymusicapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FollowRepo extends JpaRepository<Follow, String> {

  Optional<Follow> findFollowByFollowerAndFollowed(User follower, User followed);
}


