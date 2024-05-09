package com.java.backend.repository;

import com.java.backend.model.ClassTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassTeacherRepository extends JpaRepository<ClassTeacher, Long> {
    // Define custom query methods if needed
}
