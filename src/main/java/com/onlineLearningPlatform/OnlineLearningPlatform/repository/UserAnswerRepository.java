package com.onlineLearningPlatform.OnlineLearningPlatform.repository;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long>{

    //Find all answers submitted by a specific user
    List<UserAnswer> findByUserUserId(Long userId);

    //Find all answers for a specific quiz
    List<UserAnswer> findByQuizQuizId(Long answerId);

    //Find all answers for a specific question
    List<UserAnswer> findByQuestionQuestionId(Long questionId);


}
