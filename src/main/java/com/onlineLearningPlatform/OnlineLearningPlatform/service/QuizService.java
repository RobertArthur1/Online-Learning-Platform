package com.onlineLearningPlatform.OnlineLearningPlatform.service;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.Quiz;
import com.onlineLearningPlatform.OnlineLearningPlatform.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public Quiz saveQuiz(Quiz quiz) {
        quiz.setCreatedAt(LocalDateTime.now());
        return quizRepository.save(quiz);
    }

    public Optional<Quiz> findQuizById(Long quizId) {
        return quizRepository.findById(quizId);
    }

    public List<Quiz> findQuizzesByCourseId(Long courseId) {
        return quizRepository.findByCourse_CourseId(courseId);
    }

    public List<Quiz> findQuizzesByQuizId(Long quizId) {
        return quizRepository.findByQuizId(quizId);
    }

    public List<Quiz> findQuizzesByQuizName(String quizName) {
        return quizRepository.findByQuizNameContainingIgnoreCase(quizName);
    }

    public Optional<Quiz> findQuizByIdAndCourseId(Long quizId, Long courseId) {
        return quizRepository.findByQuizIdAndCourse_CourseId(quizId, courseId);
    }

    public Quiz updateQuiz(Long quizId, Quiz updatedQuiz) {
        Optional<Quiz> existingQuiz = findQuizById(quizId);
        if (existingQuiz.isPresent()) {
            Quiz quiz = existingQuiz.get();
            quiz.setCourse(updatedQuiz.getCourse());
            quiz.setQuizName(updatedQuiz.getQuizName());
            quiz.setDescription(updatedQuiz.getDescription());
            return quizRepository.save(quiz);
        }
        return null;
    }

    public void deleteQuiz(Long quizId) {
        quizRepository.deleteById(quizId);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }
}