package com.onlineLearningPlatform.OnlineLearningPlatform.repository;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    List<Resource> findByCourse_CourseId(Long courseId);

    List<Resource> findByResourceType(String resourceType);

    List<Resource> findByResourceNameContainingIgnoreCase(String resourceName);

    Optional<Resource> findByResourceNameAndCourse_CourseId(String resourceName, Long courseId);
}