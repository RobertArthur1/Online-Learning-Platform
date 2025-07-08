package com.onlineLearningPlatform.OnlineLearningPlatform.controller;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.CourseEnrollment;
import com.onlineLearningPlatform.OnlineLearningPlatform.service.CourseEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/course-enrollments")
public class CourseEnrollmentController {

    @Autowired
    private CourseEnrollmentService courseEnrollmentService;

    @PostMapping
    public ResponseEntity<CourseEnrollment> createCourseEnrollment(@RequestBody CourseEnrollment courseEnrollment) {
        return ResponseEntity.ok(courseEnrollmentService.saveCourseEnrollment(courseEnrollment));
    }

    @GetMapping("/{enrollmentId}")
    public ResponseEntity<CourseEnrollment> getCourseEnrollmentById(@PathVariable Long enrollmentId) {
        Optional<CourseEnrollment> enrollment = courseEnrollmentService.findCourseEnrollmentById(enrollmentId);
        return enrollment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CourseEnrollment>> getEnrollmentsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(courseEnrollmentService.findEnrollmentsByUserId(userId));
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<CourseEnrollment>> getEnrollmentsByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.ok(courseEnrollmentService.findEnrollmentsByCourseId(courseId));
    }

    @GetMapping("/user/{userId}/course/{courseId}")
    public ResponseEntity<CourseEnrollment> getEnrollmentByUserIdAndCourseId(@PathVariable Long userId, @PathVariable Long courseId) {
        Optional<CourseEnrollment> enrollment = courseEnrollmentService.findEnrollmentByUserIdAndCourseId(userId, courseId);
        return enrollment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{enrollmentId}")
    public ResponseEntity<CourseEnrollment> updateCourseEnrollment(@PathVariable Long enrollmentId, @RequestBody CourseEnrollment courseEnrollment) {
        CourseEnrollment updatedEnrollment = courseEnrollmentService.updateCourseEnrollment(enrollmentId, courseEnrollment);
        return updatedEnrollment != null ? ResponseEntity.ok(updatedEnrollment) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{enrollmentId}")
    public ResponseEntity<Void> deleteCourseEnrollment(@PathVariable Long enrollmentId) {
        courseEnrollmentService.deleteCourseEnrollment(enrollmentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CourseEnrollment>> getAllCourseEnrollments() {
        return ResponseEntity.ok(courseEnrollmentService.getAllCourseEnrollments());
    }
}