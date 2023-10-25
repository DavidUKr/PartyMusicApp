package com.partymusicapp.repository;

import com.partymusicapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    User findUserById(String userId);
    User findUserByName(String name);
}
