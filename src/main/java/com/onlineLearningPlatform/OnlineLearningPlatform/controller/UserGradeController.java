package com.onlineLearningPlatform.OnlineLearningPlatform.controller;

import com.onlineLearningPlatform.OnlineLearningPlatform.Entity.UserGrade;
import com.onlineLearningPlatform.OnlineLearningPlatform.service.UserGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-grades")
public class UserGradeController {

    @Autowired
    private UserGradeService userGradeService;

    @PostMapping
    public ResponseEntity<UserGrade> createUserGrade(@RequestBody UserGrade userGrade) {
        return ResponseEntity.ok(userGradeService.saveUserGrade(userGrade));
    }
}