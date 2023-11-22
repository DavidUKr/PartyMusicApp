package com.partymusicapp.repository;

import com.partymusicapp.models.Follow;
import com.partymusicapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepo extends JpaRepository<Follow, String> {

  Follow findFollowerByFollowerId(User followerId);
}


