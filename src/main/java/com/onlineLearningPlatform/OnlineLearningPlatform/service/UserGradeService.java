package com.onlineLearningPlatform.OnlineLearningPlatform.service;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.UserGrade;
import com.onlineLearningPlatform.OnlineLearningPlatform.repository.UserGradeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserGradeService {

    private UserGradeRepository userGradeRepository;

    // Save a new user grade
    public UserGrade saveUserGrade(UserGrade userGrade) {
        userGrade.setCreatedAt(LocalDateTime.now());
        return userGradeRepository.save(userGrade);
    }
}
