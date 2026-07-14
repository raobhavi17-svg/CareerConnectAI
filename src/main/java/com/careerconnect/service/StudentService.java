package com.careerconnect.service;

import com.careerconnect.model.entity.Student;

import java.util.List;

public interface StudentService {

    Student registerStudent(Student student);

    Student getStudentById(String studentId);

    List<Student> getAllStudents();

    void deleteStudent(String studentId);
}