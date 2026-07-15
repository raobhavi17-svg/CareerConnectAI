package com.careerconnect.service;

import com.careerconnect.dto.request.StudentRequest;
import com.careerconnect.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse registerStudent(StudentRequest request);

    StudentResponse getStudentById(String studentId);

    List<StudentResponse> getAllStudents();

    void deleteStudent(String studentId);
}