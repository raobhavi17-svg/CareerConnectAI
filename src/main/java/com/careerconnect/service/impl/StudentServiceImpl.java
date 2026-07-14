package com.careerconnect.service.impl;

import com.careerconnect.model.entity.Student;
import com.careerconnect.repository.StudentRepository;
import com.careerconnect.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(String studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(String studentId) {
        studentRepository.deleteById(studentId);
    }
}