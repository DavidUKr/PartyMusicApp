package com.partymusicapp.repository;

import com.partymusicapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    Optional<User> findUserById(String userId);
    Optional<User> findUserByUsername(String username);

}