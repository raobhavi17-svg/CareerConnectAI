package com.careerconnect.mapper;

import com.careerconnect.dto.response.ApplicationResponse;
import com.careerconnect.model.entity.Application;
import org.springframework.stereotype.Component;

@Component
public class ApplicationMapper {

    public ApplicationResponse toResponse(Application application){

        return ApplicationResponse.builder()
                .applicationId(application.getApplicationId())
                .studentId(application.getStudent().getStudentId())
                .studentName(application.getStudent().getName())
                .driveId(application.getPlacementDrive().getDriveId())
                .driveTitle(application.getPlacementDrive().getTitle())
                .appliedOn(application.getAppliedOn())
                .status(application.getStatus())
                .build();
    }
}