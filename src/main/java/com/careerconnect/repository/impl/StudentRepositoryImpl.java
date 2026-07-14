package com.careerconnect.repository.impl;

import com.careerconnect.model.entity.Student;
import com.careerconnect.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final Map<String, Student> students = new HashMap<>();

    @Override
    public Student save(Student student) {
        students.put(student.getStudentId(), student);
        return student;
    }

    @Override
    public Optional<Student> findById(String studentId) {
        return Optional.ofNullable(students.get(studentId));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public void deleteById(String studentId) {
        students.remove(studentId);
    }
}
