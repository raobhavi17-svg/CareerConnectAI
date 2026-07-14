package com.careerconnect.service.impl;

import com.careerconnect.model.entity.PlacementDrive;
import com.careerconnect.repository.PlacementDriveRepository;
import com.careerconnect.service.PlacementDriveService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacementDriveServiceImpl implements PlacementDriveService {

    private final PlacementDriveRepository placementDriveRepository;

    public PlacementDriveServiceImpl(PlacementDriveRepository placementDriveRepository) {
        this.placementDriveRepository = placementDriveRepository;
    }

    @Override
    public PlacementDrive createDrive(PlacementDrive drive) {
        return placementDriveRepository.save(drive);
    }

    @Override
    public PlacementDrive getDriveById(String driveId) {
        return placementDriveRepository.findById(driveId)
                .orElseThrow(() -> new RuntimeException("Placement Drive not found"));
    }

    @Override
    public List<PlacementDrive> getAllDrives() {
        return placementDriveRepository.findAll();
    }
}
