package com.careerconnect.repository;

import com.careerconnect.model.entity.PlacementDrive;

import java.util.List;
import java.util.Optional;

public interface PlacementDriveRepository {

    PlacementDrive save(PlacementDrive drive);

    Optional<PlacementDrive> findById(String driveId);

    List<PlacementDrive> findAll();

}