package com.onlineLearningPlatform.OnlineLearningPlatform.repository;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.CourseEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseEnrollmentRepository extends JpaRepository<CourseEnrollment, Long> {

    List<CourseEnrollment> findByUser_UserId(Long userId);

    List<CourseEnrollment> findByCourse_CourseId(Long courseId);

    Optional<CourseEnrollment> findByUser_UserIdAndCourse_CourseId(Long userId, Long courseId);
}