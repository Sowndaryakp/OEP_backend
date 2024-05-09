package com.java.backend.service;

import com.java.backend.model.ClassTeacher;
import com.java.backend.repository.ClassTeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassTeacherServiceImpl implements ClassTeacherService {

    @Autowired
    private ClassTeacherRepository classTeacherRepository;

    @Override
    public ClassTeacher approveClassTeacher(ClassTeacher classTeacher) {
        // Implement approval logic here
        // For example, you can save the class teacher entity to the database
        return classTeacherRepository.save(classTeacher);
    }
}