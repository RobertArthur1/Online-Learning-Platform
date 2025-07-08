package com.onlineLearningPlatform.OnlineLearningPlatform.controller;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.Question;
import com.onlineLearningPlatform.OnlineLearningPlatform.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionService.saveQuestion(question));
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long questionId) {
        Optional<Question> question = questionService.findQuestionById(questionId);
        return question.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<Question>> getQuestionsByQuizId(@PathVariable Long quizId) {
        return ResponseEntity.ok(questionService.findQuestionsByQuizId(quizId));
    }

    @GetMapping("/correct-option/{correctOption}")
    public ResponseEntity<List<Question>> getQuestionsByCorrectOption(@PathVariable String correctOption) {
        return ResponseEntity.ok(questionService.findQuestionsByCorrectOption(correctOption));
    }

    @GetMapping("/quiz/{quizId}/question/{questionId}")
    public ResponseEntity<Question> getQuestionByQuizIdAndQuestionId(@PathVariable Long quizId, @PathVariable Long questionId) {
        Optional<Question> question = questionService.findQuestionByQuizIdAndQuestionId(quizId, questionId);
        return question.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{questionId}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long questionId, @RequestBody Question question) {
        Question updatedQuestion = questionService.updateQuestion(questionId, question);
        return updatedQuestion != null ? ResponseEntity.ok(updatedQuestion) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long questionId) {
        questionService.deleteQuestion(questionId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }
}