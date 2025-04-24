package com.onlineLearningPlatform.OnlineLearningPlatform.repository;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Find courses by instructor id
    List<Course> findByInstructorUserId(Long instructorId);

    // Find courses by course name
    List<Course> findByCourseNameContainingIgnoreCase(String courseName);

    // Find courses by enrollment status
    List<Course> findByEnrollments_User_UserAndCourseId(Long userId);

    // Find a course by it id
    Optional<Course> findByCourseId(Long courseId);
}
