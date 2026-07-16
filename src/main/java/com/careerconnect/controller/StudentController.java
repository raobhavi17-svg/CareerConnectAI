package com.careerconnect.controller;

import com.careerconnect.dto.request.StudentRequest;
import com.careerconnect.dto.response.StudentResponse;
import com.careerconnect.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(
        name = "Student API",
        description = "Operations related to student management"
)
@RestController
@RequestMapping("/students")

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @Operation(summary = "Register a new student")

    @PostMapping
    public ResponseEntity<StudentResponse> registerStudent(
            @Valid @RequestBody StudentRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.registerStudent(request));
    }
    @Operation(summary = "Get student by ID")

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudent(
            @PathVariable String id) {

        return ResponseEntity.ok(studentService.getStudentById(id));
    }
    @Operation(summary = "Get student by ID")

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