package com.careerconnect.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationRequest {

    @NotBlank(message = "Application ID is required")
    private String applicationId;

    @NotBlank(message = "Student ID is required")
    private String studentId;

    @NotBlank(message = "Drive ID is required")
    private String driveId;
}