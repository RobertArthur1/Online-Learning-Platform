package com.onlineLearningPlatform.OnlineLearningPlatform.Entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courses;

    @OneToMany(mappedBy = "user")
    private List<CourseEnrollment> enrollments;

    @OneToMany(mappedBy = "user")
    private List<UserAnswer> answers;

    @OneToMany(mappedBy = "user")
    private List<UserGrade> grades;


    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setEnrollments(List<CourseEnrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public void setAnswers(List<UserAnswer> answers) {
        this.answers = answers;
    }

    public void setGrades(List<UserGrade> grades) {
        this.grades = grades;
    }
}

