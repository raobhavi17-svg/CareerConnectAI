package com.careerconnect.service.impl;

import com.careerconnect.dto.request.StudentRequest;
import com.careerconnect.dto.response.StudentResponse;
import com.careerconnect.exception.DuplicateStudentException;
import com.careerconnect.exception.StudentNotFoundException;
import com.careerconnect.mapper.StudentMapper;
import com.careerconnect.model.entity.Student;
import com.careerconnect.repository.StudentRepository;
import com.careerconnect.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository,
                              StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentResponse registerStudent(StudentRequest request) {

        studentRepository.findById(request.getStudentId())
                .ifPresent(student -> {
                    throw new DuplicateStudentException("Student already exists.");
                });

        Student student = studentMapper.toEntity(request);

        Student savedStudent = studentRepository.save(student);

        return studentMapper.toResponse(savedStudent);
    }

    @Override
    public StudentResponse getStudentById(String studentId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with ID: " + studentId));

        return studentMapper.toResponse(student);
    }

    @Override
    public List<StudentResponse> getAllStudents() {

        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteStudent(String studentId) {
        studentRepository.deleteById(studentId);
    }
}