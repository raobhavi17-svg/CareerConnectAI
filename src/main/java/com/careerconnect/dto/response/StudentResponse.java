package com.careerconnect.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class StudentResponse {

    private String studentId;

    private String name;

    private String email;

    private String programme;

    private Integer graduationYear;

    private Double cgpa;

    private Integer activeBacklogs;

    private List<String> skills;

}