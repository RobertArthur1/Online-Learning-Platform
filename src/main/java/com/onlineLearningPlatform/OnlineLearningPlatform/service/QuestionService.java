package com.onlineLearningPlatform.OnlineLearningPlatform.service;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.Question;
import com.onlineLearningPlatform.OnlineLearningPlatform.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question saveQuestion(Question question) {
        question.setCreatedAt(LocalDateTime.now());
        return questionRepository.save(question);
    }

    public Optional<Question> findQuestionById(Long questionId) {
        return questionRepository.findById(questionId);
    }

    public List<Question> findQuestionsByQuizId(Long quizId) {
        return questionRepository.findByQuiz_QuizId(quizId);
    }

    public List<Question> findQuestionsByCorrectOption(String correctOption) {
        return questionRepository.findByCorrectOption(correctOption);
    }

    public Optional<Question> findQuestionByQuizIdAndQuestionId(Long quizId, Long questionId) {
        return questionRepository.findByQuiz_QuizIdAndQuestionId(quizId, questionId);
    }

    public Question updateQuestion(Long questionId, Question updatedQuestion) {
        Optional<Question> existingQuestion = findQuestionById(questionId);
        if (existingQuestion.isPresent()) {
            Question question = existingQuestion.get();
            question.setQuiz(updatedQuestion.getQuiz());
            question.setQuestionText(updatedQuestion.getQuestionText());
            question.setOptionA(updatedQuestion.getOptionA());
            question.setOptionB(updatedQuestion.getOptionB());
            question.setOptionC(updatedQuestion.getOptionC());
            question.setOptionD(updatedQuestion.getOptionD());
            question.setCorrectOption(updatedQuestion.getCorrectOption());
            return questionRepository.save(question);
        }
        return null;
    }

    public void deleteQuestion(Long questionId) {
        questionRepository.deleteById(questionId);
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}