package com.onlineLearningPlatform.OnlineLearningPlatform.controller;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.Resource;
import com.onlineLearningPlatform.OnlineLearningPlatform.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping
    public ResponseEntity<Resource> createResource(@RequestBody Resource resource) {
        return ResponseEntity.ok(resourceService.saveResource(resource));
    }

    @GetMapping("/{resourceId}")
    public ResponseEntity<Resource> getResourceById(@PathVariable Long resourceId) {
        Optional<Resource> resource = resourceService.findResourceById(resourceId);
        return resource.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Resource>> getResourcesByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.ok(resourceService.findResourcesByCourseId(courseId));
    }

    @GetMapping("/type/{resourceType}")
    public ResponseEntity<List<Resource>> getResourcesByResourceType(@PathVariable String resourceType) {
        return ResponseEntity.ok(resourceService.findResourcesByResourceType(resourceType));
    }

    @GetMapping("/name/{resourceName}")
    public ResponseEntity<List<Resource>> getResourcesByResourceName(@PathVariable String resourceName) {
        return ResponseEntity.ok(resourceService.findResourcesByResourceName(resourceName));
    }

    @GetMapping("/course/{courseId}/name/{resourceName}")
    public ResponseEntity<Resource> getResourceByNameAndCourseId(@PathVariable String resourceName, @PathVariable Long courseId) {
        Optional<Resource> resource = resourceService.findResourceByNameAndCourseId(resourceName, courseId);
        return resource.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{resourceId}")
    public ResponseEntity<Resource> updateResource(@PathVariable Long resourceId, @RequestBody Resource resource) {
        Resource updatedResource = resourceService.updateResource(resourceId, resource);
        return updatedResource != null ? ResponseEntity.ok(updatedResource) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{resourceId}")
    public ResponseEntity<Void> deleteResource(@PathVariable Long resourceId) {
        resourceService.deleteResource(resourceId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Resource>> getAllResources() {
        return ResponseEntity.ok(resourceService.getAllResources());
    }
}