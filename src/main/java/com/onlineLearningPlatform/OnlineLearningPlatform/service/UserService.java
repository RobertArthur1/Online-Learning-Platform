package com.onlineLearningPlatform.OnlineLearningPlatform.service;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.User;
import com.onlineLearningPlatform.OnlineLearningPlatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // create or save a new user
    public User saveUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    // find user by user Id
    public Optional<User> findUserById(Long userId) {
        return userRepository.findById(userId);
    }

    // find user by username
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // find user by email
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // find all users by role
    public List<User> findUsersByRole(String role) {
        return userRepository.findByRole(role);
    }

    // update user details
    public User updateUser(Long userId, User updatedUser) {
        Optional<User> existingUser = findUserById(userId);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setRole(updatedUser.getRole());
            return userRepository.save(user);
        }
        return null;
    }

    // Delete user by userId
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    // get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
