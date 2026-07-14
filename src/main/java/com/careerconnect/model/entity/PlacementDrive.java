package com.careerconnect.model.entity;

import com.careerconnect.model.enums.DriveStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlacementDrive {

    private String driveId;
    private String title;
    private Company company;

    private LocalDate driveDate;

    private List<String> requiredSkills;

    private Double minimumCgpa;

    private Integer maximumBacklogs;

    private DriveStatus status;

}
