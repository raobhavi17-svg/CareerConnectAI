package com.careerconnect.service;

import com.careerconnect.dto.request.PlacementDriveRequest;
import com.careerconnect.dto.response.PlacementDriveResponse;

import java.util.List;

public interface PlacementDriveService {

    PlacementDriveResponse createDrive(PlacementDriveRequest request);

    PlacementDriveResponse getDriveById(String driveId);

    List<PlacementDriveResponse> getAllDrives();
}
