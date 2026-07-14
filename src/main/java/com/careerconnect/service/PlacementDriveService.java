package com.careerconnect.service;

import com.careerconnect.model.entity.PlacementDrive;

import java.util.List;

public interface PlacementDriveService {

    PlacementDrive createDrive(PlacementDrive drive);

    PlacementDrive getDriveById(String driveId);

    List<PlacementDrive> getAllDrives();
}
