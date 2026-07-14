package com.careerconnect.repository.impl;

import com.careerconnect.model.entity.PlacementDrive;
import com.careerconnect.repository.PlacementDriveRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PlacementDriveRepositoryImpl implements PlacementDriveRepository {

    private final Map<String, PlacementDrive> drives = new HashMap<>();

    @Override
    public PlacementDrive save(PlacementDrive drive) {
        drives.put(drive.getDriveId(), drive);
        return drive;
    }

    @Override
    public Optional<PlacementDrive> findById(String driveId) {
        return Optional.ofNullable(drives.get(driveId));
    }

    @Override
    public List<PlacementDrive> findAll() {
        return new ArrayList<>(drives.values());
    }
}