package com.java.backend.controller;

import com.java.backend.model.ClassTeacher;
import com.java.backend.service.ClassTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/class-teachers")
public class ClassTeacherController {

    @Autowired
    private ClassTeacherService classTeacherService;

    @PostMapping("/approve")
    public ClassTeacher approveClassTeacher(@RequestBody ClassTeacher classTeacher) {
        return classTeacherService.approveClassTeacher(classTeacher);
    }
}