package com.careerconnect.dto.response;

import com.careerconnect.model.enums.ApplicationStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ApplicationResponse {

    private String applicationId;
    private String studentId;
    private String studentName;
    private String driveId;
    private String driveTitle;
    private LocalDateTime appliedOn;
    private ApplicationStatus status;
}