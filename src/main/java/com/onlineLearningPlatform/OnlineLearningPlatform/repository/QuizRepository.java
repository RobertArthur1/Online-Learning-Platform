package com.onlineLearningPlatform.OnlineLearningPlatform.repository;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    // find quiz by course id
    List<Quiz> findByCourse_CourseId(Long courseId);

    // find a quiz by quiz id
    List<Quiz> findByQuizId(Long quizId);

    // find quiz by the quiz name
    List<Quiz> findByQuizNameContainingIgnoreCase(String quizName);

    // find all quizzes in a course
    List<Quiz> findByCourse(Long courseId);

    // find a quiz by it id and associated course id
    Optional<Quiz> findByQuizIdAndCourse_CourseId(Long quizId, Long courseId);

}
