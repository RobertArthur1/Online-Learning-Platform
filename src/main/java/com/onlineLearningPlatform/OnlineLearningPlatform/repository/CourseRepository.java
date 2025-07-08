package com.onlineLearningPlatform.OnlineLearningPlatform.repository;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByInstructor_UserId(Long instructorId);

    List<Course> findByCourseNameContainingIgnoreCase(String courseName);

    List<Course> findByEnrollments_User_UserId(Long userId);
}