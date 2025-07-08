package com.onlineLearningPlatform.OnlineLearningPlatform.service;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.Course;
import com.onlineLearningPlatform.OnlineLearningPlatform.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course saveCourse(Course course) {
        course.setCreatedAt(LocalDateTime.now());
        course.setUpdatedAt(LocalDateTime.now());
        return courseRepository.save(course);
    }

    public Optional<Course> findCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    public List<Course> findCoursesByInstructorId(Long instructorId) {
        return courseRepository.findByInstructor_UserId(instructorId);
    }

    public List<Course> findCoursesByCourseName(String courseName) {
        return courseRepository.findByCourseNameContainingIgnoreCase(courseName);
    }

    public List<Course> findCoursesByUserEnrollment(Long userId) {
        return courseRepository.findByEnrollments_User_UserId(userId);
    }

    public Course updateCourse(Long courseId, Course updatedCourse) {
        Optional<Course> existingCourse = findCourseById(courseId);
        if (existingCourse.isPresent()) {
            Course course = existingCourse.get();
            course.setCourseName(updatedCourse.getCourseName());
            course.setDescription(updatedCourse.getDescription());
            course.setInstructor(updatedCourse.getInstructor());
            course.setUpdatedAt(LocalDateTime.now());
            return courseRepository.save(course);
        }
        return null;
    }

    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}