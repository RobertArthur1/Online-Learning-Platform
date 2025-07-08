package com.onlineLearningPlatform.OnlineLearningPlatform.controller;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.UserAnswer;
import com.onlineLearningPlatform.OnlineLearningPlatform.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-answers")
public class UserAnswerController {

    @Autowired
    private UserAnswerService userAnswerService;

    @PostMapping
    public ResponseEntity<UserAnswer> createUserAnswer(@RequestBody UserAnswer userAnswer) {
        return ResponseEntity.ok(userAnswerService.saveUserAnswer(userAnswer));
    }

    @GetMapping("/{userAnswerId}")
    public ResponseEntity<UserAnswer> getUserAnswerById(@PathVariable Long userAnswerId) {
        Optional<UserAnswer> userAnswer = userAnswerService.findUserAnswerById(userAnswerId);
        return userAnswer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserAnswer>> getUserAnswersByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(userAnswerService.findUserAnswersByUserId(userId));
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<UserAnswer>> getUserAnswersByQuizId(@PathVariable Long quizId) {
        return ResponseEntity.ok(userAnswerService.findUserAnswersByQuizId(quizId));
    }

    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<UserAnswer>> getUserAnswersByQuestionId(@PathVariable Long questionId) {
        return ResponseEntity.ok(userAnswerService.findUserAnswersByQuestionId(questionId));
    }

    @PutMapping("/{userAnswerId}")
    public ResponseEntity<UserAnswer> updateUserAnswer(@PathVariable Long userAnswerId, @RequestBody UserAnswer userAnswer) {
        UserAnswer updatedUserAnswer = userAnswerService.updateUserAnswer(userAnswerId, userAnswer);
        return updatedUserAnswer != null ? ResponseEntity.ok(updatedUserAnswer) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{userAnswerId}")
    public ResponseEntity<Void> deleteUserAnswer(@PathVariable Long userAnswerId) {
        userAnswerService.deleteUserAnswer(userAnswerId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UserAnswer>> getAllUserAnswers() {
        return ResponseEntity.ok(userAnswerService.getAllUserAnswers());
    }
}