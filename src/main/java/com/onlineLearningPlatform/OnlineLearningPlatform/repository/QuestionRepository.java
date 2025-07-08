package com.onlineLearningPlatform.OnlineLearningPlatform.repository;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByQuiz_QuizId(Long quizId);

    List<Question> findByCorrectOption(String correctOption);

    Optional<Question> findByQuiz_QuizIdAndQuestionId(Long quizId, Long questionId);
}