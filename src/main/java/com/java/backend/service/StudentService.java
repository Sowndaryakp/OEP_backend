package com.java.backend.service;

import com.java.backend.model.Student;

public interface StudentService {
    Student registerStudent(Student student);
    Student loginStudent(String email, String password);
}

