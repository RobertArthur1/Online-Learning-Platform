package com.onlineLearningPlatform.OnlineLearningPlatform.repository;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    // find all resources by the course id
    List<Resource> findByCourse_CourseId(Long courseId);

    // find all resources by course
    List<Resource> findByCourse(Long courseId);

    // find resource by resource type
    List<Resource> findByResourceType(String resourceType);

    // find resources by resource name
    List<Resource> findByResourceNameContainingIgnoreCase(String resourceName);

    // find a resource by it name and associated course id
    Optional<Resource> findByResourceNameAndCourse_CourseId(String resourceName, Long courseId);

    // find a resource by it id
    Optional<Resource> findByResourceId(Long resourceId);
}
