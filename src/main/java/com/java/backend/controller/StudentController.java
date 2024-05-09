package com.java.backend.controller;

import com.java.backend.model.AuthResponse;
import com.java.backend.model.Student;
import com.java.backend.service.StudentService;
import com.java.backend.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public Student registerStudent(@RequestBody Student student) {
        return studentService.registerStudent(student);
    }

//    @PostMapping("/login")
//    public String loginStudent(@RequestBody Student student) {
//        Student authenticatedStudent = studentService.loginStudent(student.getEmail(), student.getPassword());
//        if (authenticatedStudent != null) {
//            return "Login successful";
//        } else {
//            return "Invalid email or password";
//        }
//    }

    @PostMapping("/login")
    public ResponseEntity<?> loginStudent(@RequestBody Student student) {
        Student authenticatedStudent = studentService.loginStudent(student.getEmail(), student.getPassword());
        if (authenticatedStudent != null) {
            String token = jwtTokenUtil.generateToken(authenticatedStudent);
            boolean approved = authenticatedStudent.isApproved();
            AuthResponse response = new AuthResponse("Login successful", token, approved); // Create AuthResponse object
            return ResponseEntity.ok(response); // Return response entity with AuthResponse object
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

    // Method to generate token for the authenticated student
    private String generateTokenForStudent(Student student) {
        // Generate token using your token generation logic (e.g., using JwtTokenUtil)
        String token = jwtTokenUtil.generateToken(student);
        return token;
    }


}