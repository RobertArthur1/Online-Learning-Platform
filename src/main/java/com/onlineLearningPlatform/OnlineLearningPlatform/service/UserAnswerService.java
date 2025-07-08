package com.onlineLearningPlatform.OnlineLearningPlatform.service;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.UserAnswer;
import com.onlineLearningPlatform.OnlineLearningPlatform.repository.UserAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserAnswerService {


    private UserAnswerRepository userAnswerRepository;

    public UserAnswer saveUserAnswer(UserAnswer userAnswer) {
        userAnswer.setCreatedAt(LocalDateTime.now());
        return userAnswerRepository.save(userAnswer);
    }

    public Optional<UserAnswer> findUserAnswerById(Long userAnswerId) {
        return userAnswerRepository.findById(userAnswerId);
    }

    public List<UserAnswer> findUserAnswersByUserId(Long userId) {
        return userAnswerRepository.findByUserUserId(userId);
    }

    public List<UserAnswer> findUserAnswersByQuizId(Long quizId) {
        return userAnswerRepository.findByQuizQuizId(quizId);
    }

    public List<UserAnswer> findUserAnswersByQuestionId(Long questionId) {
        return userAnswerRepository.findByQuestionQuestionId(questionId);
    }

    public UserAnswer updateUserAnswer(Long userAnswerId, UserAnswer updatedUserAnswer) {
        Optional<UserAnswer> existingUserAnswer = findUserAnswerById(userAnswerId);
        if (existingUserAnswer.isPresent()) {
            UserAnswer userAnswer = existingUserAnswer.get();
            userAnswer.setUser(updatedUserAnswer.getUser());
            userAnswer.setChosenOption(updatedUserAnswer.getChosenOption());
            userAnswer.setQuiz(updatedUserAnswer.getQuiz());
            userAnswer.setQuestion(updatedUserAnswer.getQuestion());
            return userAnswerRepository.save(userAnswer);
        }
        return null;
    }

    public void deleteUserAnswer(Long userAnswerId) {
        userAnswerRepository.deleteById(userAnswerId);
    }

    public List<UserAnswer> getAllUserAnswers() {
        return userAnswerRepository.findAll();
    }
}