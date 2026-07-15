package com.careerconnect.dto.request;

import com.careerconnect.model.enums.DriveStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PlacementDriveRequest {

    @NotBlank(message = "Drive ID is required")
    private String driveId;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Company ID is required")
    private String companyId;

    @NotNull(message = "Drive date is required")
    private LocalDate driveDate;

    @NotNull(message = "Required skills are required")
    private List<String> requiredSkills;

    @NotNull(message = "Minimum CGPA is required")
    private Double minimumCgpa;

    @NotNull(message = "Maximum backlogs are required")
    private Integer maximumBacklogs;

    @NotNull(message = "Status is required")
    private DriveStatus status;
}