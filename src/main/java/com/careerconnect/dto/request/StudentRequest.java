package com.careerconnect.dto.request;

import jakarta.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentRequest {

    @NotBlank(message = "Student ID is required")
    private String studentId;

    @NotBlank(message = "Student name is required")
    private String name;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Programme is required")
    private String programme;

    @NotNull(message = "Graduation year is required")
    private Integer graduationYear;

    @DecimalMin(value = "0.0")
    @DecimalMax(value = "10.0")
    private Double cgpa;

    @NotNull
    private Integer activeBacklogs;

    @NotEmpty(message = "Skills cannot be empty")
    private List<String> skills;

}