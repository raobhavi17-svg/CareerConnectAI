package com.careerconnect.controller;

import com.careerconnect.dto.request.StudentRequest;
import com.careerconnect.dto.response.StudentResponse;
import com.careerconnect.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponse> registerStudent(
            @Valid @RequestBody StudentRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.registerStudent(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudent(
            @PathVariable String id) {

        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudents() {

        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {

        studentService.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }
}