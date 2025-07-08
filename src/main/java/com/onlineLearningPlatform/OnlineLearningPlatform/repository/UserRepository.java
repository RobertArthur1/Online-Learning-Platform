package com.onlineLearningPlatform.OnlineLearningPlatform.repository;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    //Find user by username
    Optional<User> findByUsername(String username);

    //Find user by email
    Optional<User> findByEmail(String email);

    //Check if username already exist
    boolean existsByUsername(String username);

    //Check if email already exists
    boolean existsByEmail(String email);

    //Find all users by row
    List<User> findByRole(String role);


}
