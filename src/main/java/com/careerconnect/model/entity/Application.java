package com.careerconnect.model.entity;

import com.careerconnect.model.enums.ApplicationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {

    private String applicationId;

    private Student student;

    private PlacementDrive placementDrive;

    private LocalDateTime appliedOn;

    private ApplicationStatus status;

}