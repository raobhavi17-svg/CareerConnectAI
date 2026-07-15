package com.careerconnect.mapper;

import com.careerconnect.dto.response.PlacementDriveResponse;
import com.careerconnect.model.entity.PlacementDrive;
import org.springframework.stereotype.Component;

@Component
public class PlacementDriveMapper {

    public PlacementDriveResponse toResponse(PlacementDrive drive){

        return PlacementDriveResponse.builder()
                .driveId(drive.getDriveId())
                .title(drive.getTitle())
                .companyId(drive.getCompany().getCompanyId())
                .companyName(drive.getCompany().getCompanyName())
                .driveDate(drive.getDriveDate())
                .requiredSkills(drive.getRequiredSkills())
                .minimumCgpa(drive.getMinimumCgpa())
                .maximumBacklogs(drive.getMaximumBacklogs())
                .status(drive.getStatus())
                .build();
    }
}