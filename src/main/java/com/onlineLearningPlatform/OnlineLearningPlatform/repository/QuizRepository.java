package com.onlineLearningPlatform.OnlineLearningPlatform.repository;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    List<Quiz> findByCourse_CourseId(Long courseId);

    List<Quiz> findByQuizId(Long quizId);

    List<Quiz> findByQuizNameContainingIgnoreCase(String quizName);

    Optional<Quiz> findByQuizIdAndCourse_CourseId(Long quizId, Long courseId);
}