package com.onlineLearningPlatform.OnlineLearningPlatform.service;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.CourseEnrollment;
import com.onlineLearningPlatform.OnlineLearningPlatform.repository.CourseEnrollmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CourseEnrollmentService {

    private final CourseEnrollmentRepository enrollmentRepository;

    public CourseEnrollmentService(CourseEnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public CourseEnrollment saveCourseEnrollment(CourseEnrollment courseEnrollment) {
        courseEnrollment.setCreatedAt(LocalDateTime.now());
        return enrollmentRepository.save(courseEnrollment);
    }

    public Optional<CourseEnrollment> findCourseEnrollmentById(Long enrollmentId) {
        return enrollmentRepository.findById(enrollmentId);
    }

    public List<CourseEnrollment> getAllCourseEnrollments() {
        return enrollmentRepository.findAll();
    }

    public List<CourseEnrollment> findEnrollmentsByUserId(Long userId) {
        return enrollmentRepository.findByUser_UserId(userId);
    }

    public List<CourseEnrollment> findEnrollmentsByCourseId(Long courseId) {
        return enrollmentRepository.findByCourse_CourseId(courseId);
    }

    public Optional<CourseEnrollment> findEnrollmentByUserIdAndCourseId(Long userId, Long courseId) {
        return enrollmentRepository.findByUser_UserIdAndCourse_CourseId(userId, courseId);
    }

    @Transactional
    public CourseEnrollment updateCourseEnrollment(Long enrollmentId, CourseEnrollment updatedEnrollment) {
        return enrollmentRepository.findById(enrollmentId)
                .map(existing -> {
                    existing.setUser(updatedEnrollment.getUser());
                    existing.setCourse(updatedEnrollment.getCourse());
                    return enrollmentRepository.save(existing);
                })
                .orElse(null);
    }

    @Transactional
    public void deleteCourseEnrollment(Long enrollmentId) {
        enrollmentRepository.deleteById(enrollmentId);
    }
}