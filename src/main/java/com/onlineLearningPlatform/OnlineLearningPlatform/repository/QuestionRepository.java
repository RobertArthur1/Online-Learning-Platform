package com.onlineLearningPlatform.OnlineLearningPlatform.repository;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    // find all questions by quiz id
    List<Question> findByQuiz_QuizId(Long quizId);

    // find the questions by quiz
    List<Question> findByQuiz(Long quizId);

    // find questions by the correct option
    List<Question> findByCorrectOption(String correctOption);

    // find a question by its id and associated quiz id
    Optional<Question> findByQuestionIdAndQuiz_QuizId(Long questionId, Long quizId);

    // check if a specific question exist based on the quiz
    Optional<Question> findByQuizIdAndQuestionId(Long quizId, Long questionId);
}
