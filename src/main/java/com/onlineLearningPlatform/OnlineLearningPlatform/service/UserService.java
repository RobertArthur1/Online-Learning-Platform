package com.onlineLearningPlatform.OnlineLearningPlatform.service;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.User;
import com.onlineLearningPlatform.OnlineLearningPlatform.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    public Optional<User> findUserById(Long userId) {
        return userRepository.findById(userId);
    }
}