package com.onlineLearningPlatform.OnlineLearningPlatform.repository;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.User;
import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.UserGrade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserGradeRepository extends JpaRepository<UserGrade, Long> {

    // Find all grades for a specific user
    List<User> findByUserUserId(Long userId);

    // Find all grades for a specific quiz
    List<User> findByQuizQuizId(Long quizId);
}
