package com.onlineLearningPlatform.OnlineLearningPlatform.controller;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.Quiz;
import com.onlineLearningPlatform.OnlineLearningPlatform.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(quizService.saveQuiz(quiz));
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long quizId) {
        Optional<Quiz> quiz = quizService.findQuizById(quizId);
        return quiz.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Quiz>> getQuizzesByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.ok(quizService.findQuizzesByCourseId(courseId));
    }

    @GetMapping("/name/{quizName}")
    public ResponseEntity<List<Quiz>> getQuizzesByQuizName(@PathVariable String quizName) {
        return ResponseEntity.ok(quizService.findQuizzesByQuizName(quizName));
    }

    @GetMapping("/course/{courseId}/quiz/{quizId}")
    public ResponseEntity<Quiz> getQuizByIdAndCourseId(@PathVariable Long quizId, @PathVariable Long courseId) {
        Optional<Quiz> quiz = quizService.findQuizByIdAndCourseId(quizId, courseId);
        return quiz.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{quizId}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable Long quizId, @RequestBody Quiz quiz) {
        Quiz updatedQuiz = quizService.updateQuiz(quizId, quiz);
        return updatedQuiz != null ? ResponseEntity.ok(updatedQuiz) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{quizId}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long quizId) {
        quizService.deleteQuiz(quizId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        return ResponseEntity.ok(quizService.getAllQuizzes());
    }
}