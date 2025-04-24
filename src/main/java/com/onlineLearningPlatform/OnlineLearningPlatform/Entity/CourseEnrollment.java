package com.onlineLearningPlatform.OnlineLearningPlatform.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name= "course_enrollment")
public class CourseEnrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="course_id", nullable=false)
    private Course course;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public Long getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Long enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
