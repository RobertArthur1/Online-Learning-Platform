package com.onlineLearningPlatform.OnlineLearningPlatform.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="user_answers")
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userAnswerId;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String chosenOption;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false, insertable = false, updatable = false)
    private Quiz quiz;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public long getUserAnswerId() {
        return userAnswerId;
    }

    public void setUserAnswerId(long userAnswerId) {
        this.userAnswerId = userAnswerId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getChosenOption() {
        return chosenOption;
    }

    public void setChosenOption(String chosenOption) {
        this.chosenOption = chosenOption;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
