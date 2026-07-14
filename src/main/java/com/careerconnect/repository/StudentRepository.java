package com.careerconnect.repository;

import com.careerconnect.model.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    Student save(Student student);

    Optional<Student> findById(String studentId);

    List<Student> findAll();

    void deleteById(String studentId);

}