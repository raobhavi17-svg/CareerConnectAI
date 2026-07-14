package com.careerconnect.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    private String studentId;

    private String name;

    private String email;

    private String programme;

    private Integer graduationYear;

    private Double cgpa;

    private Integer activeBacklogs;

    private List<String> skills;

}
