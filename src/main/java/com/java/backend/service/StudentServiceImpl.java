package com.java.backend.service;

import com.java.backend.model.Student;
import com.java.backend.repository.StudentRepository;
import com.java.backend.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, BCryptPasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public Student registerStudent(Student student) {
        // Set approval status to false by default
        student.setApproved(false);
        String hashedPassword = passwordEncoder.encode(student.getPassword());
        student.setPassword(hashedPassword);
        return studentRepository.save(student);
    }

    @Override
    public Student loginStudent(String email, String password) {
        // Find student by email
        Student student = studentRepository.findByEmail(email);
        if (student != null) {
            // Check if student is approved
            if (student.isApproved()) {
                // Compare hashed passwords
                if (passwordEncoder.matches(password, student.getPassword())) {
                    // Generate JWT token
                    String token = jwtTokenUtil.generateToken(student);

                    // Create a map to hold response data (you can use any other way to represent the response)
                    Map<String, Object> response = new HashMap<>();
                    response.put("token", token);
                    response.put("approved", true);

                    // Return the response
                    return student;
                }
            } else {
                return null; // Return null if student is not approved
            }
        }
        return null; // Return null if email or password doesn't match
    }

}