package com.onlineLearningPlatform.OnlineLearningPlatform.repository;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.CourseEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseEnrollmentRepository extends JpaRepository<CourseEnrollment, Long> {

    // find all user enrollment by user id
    List<CourseEnrollment> findByUserId(Long userId);

    // find all enrollments for a specific course
    List<CourseEnrollment> findByCourse_CourseId(Long courseId);

    // Check if a specific user is enrolled in a specific course
    Optional<CourseEnrollment> findByUser_UserIdAndCourse_CourseId(Long userId, Long courseId);

    // find enrollment by user and course
    List<CourseEnrollment> findByUserAndCourse(Long userId, Long courseId);
}
