package com.onlineLearningPlatform.OnlineLearningPlatform.controller;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.Course;
import com.onlineLearningPlatform.OnlineLearningPlatform.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.saveCourse(course));
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long courseId) {
        Optional<Course> course = courseService.findCourseById(courseId);
        return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/instructor/{instructorId}")
    public ResponseEntity<List<Course>> getCoursesByInstructorId(@PathVariable Long instructorId) {
        return ResponseEntity.ok(courseService.findCoursesByInstructorId(instructorId));
    }

    @GetMapping("/name/{courseName}")
    public ResponseEntity<List<Course>> getCoursesByCourseName(@PathVariable String courseName) {
        return ResponseEntity.ok(courseService.findCoursesByCourseName(courseName));
    }

    @GetMapping("/enrollment/{userId}")
    public ResponseEntity<List<Course>> getCoursesByUserEnrollment(@PathVariable Long userId) {
        return ResponseEntity.ok(courseService.findCoursesByUserEnrollment(userId));
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long courseId, @RequestBody Course course) {
        Course updatedCourse = courseService.updateCourse(courseId, course);
        return updatedCourse != null ? ResponseEntity.ok(updatedCourse) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }
}