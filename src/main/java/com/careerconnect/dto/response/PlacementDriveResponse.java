package com.careerconnect.dto.response;

import com.careerconnect.model.enums.DriveStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class PlacementDriveResponse {

    private String driveId;
    private String title;
    private String companyId;
    private String companyName;
    private LocalDate driveDate;
    private List<String> requiredSkills;
    private Double minimumCgpa;
    private Integer maximumBacklogs;
    private DriveStatus status;
}