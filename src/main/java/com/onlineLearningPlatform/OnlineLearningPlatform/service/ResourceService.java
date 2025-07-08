package com.onlineLearningPlatform.OnlineLearningPlatform.service;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.Resource;
import com.onlineLearningPlatform.OnlineLearningPlatform.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {


    private ResourceRepository resourceRepository;

    public Resource saveResource(Resource resource) {
        resource.setCreatedAt(LocalDateTime.now());
        return resourceRepository.save(resource);
    }

    public Optional<Resource> findResourceById(Long resourceId) {
        return resourceRepository.findByResourceId(resourceId);
    }

    public List<Resource> findResourcesByCourseId(Long courseId) {
        return resourceRepository.findByCourse_CourseId(courseId);
    }

    public List<Resource> findResourcesByCourse(Long courseId) {
        return resourceRepository.findByCourse(courseId);
    }

    public List<Resource> findResourcesByResourceType(String resourceType) {
        return resourceRepository.findByResourceType(resourceType);
    }

    public List<Resource> findResourcesByResourceName(String resourceName) {
        return resourceRepository.findByResourceNameContainingIgnoreCase(resourceName);
    }

    public Optional<Resource> findResourceByNameAndCourseId(String resourceName, Long courseId) {
        return resourceRepository.findByResourceNameAndCourse_CourseId(resourceName, courseId);
    }

    public Resource updateResource(Long resourceId, Resource updatedResource) {
        Optional<Resource> existingResource = findResourceById(resourceId);
        if (existingResource.isPresent()) {
            Resource resource = existingResource.get();
            resource.setCourse(updatedResource.getCourse());
            resource.setResourceType(updatedResource.getResourceType());
            resource.setResourceUrl(updatedResource.getResourceUrl());
            resource.setResourceName(updatedResource.getResourceName());
            return resourceRepository.save(resource);
        }
        return null;
    }

    public void deleteResource(Long resourceId) {
        resourceRepository.deleteById(resourceId);
    }

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }
}