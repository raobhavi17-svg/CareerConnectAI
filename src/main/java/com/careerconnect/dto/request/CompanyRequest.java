package com.careerconnect.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyRequest {

    @NotBlank(message = "Company ID is required")
    private String companyId;

    @NotBlank(message = "Company name is required")
    private String companyName;

    @NotBlank(message = "Industry is required")
    private String industry;

    @NotBlank(message = "Location is required")
    private String location;

    @NotNull(message = "Minimum CGPA is required")
    private Double minimumCgpa;

    @NotNull(message = "Maximum backlogs is required")
    private Integer maximumBacklogs;
}