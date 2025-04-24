package com.onlineLearningPlatform.OnlineLearningPlatform.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name= "user_grades")
public class UserGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userGradeId;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name="quiz_id", nullable = false)
    private Quiz quiz;

    @Column(nullable = false)
    private Double grade;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public Long getUserGradeId() {
        return userGradeId;
    }

    public void setUserGradeId(Long userGradeId) {
        this.userGradeId = userGradeId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
