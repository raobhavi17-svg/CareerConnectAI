package com.careerconnect.controller;

import com.careerconnect.model.entity.PlacementDrive;
import com.careerconnect.service.PlacementDriveService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drives")
public class PlacementDriveController {

    private final PlacementDriveService placementDriveService;

    public PlacementDriveController(PlacementDriveService placementDriveService) {
        this.placementDriveService = placementDriveService;
    }

    @PostMapping
    public PlacementDrive createDrive(@RequestBody PlacementDrive drive) {
        return placementDriveService.createDrive(drive);
    }

    @GetMapping("/{id}")
    public PlacementDrive getDrive(@PathVariable String id) {
        return placementDriveService.getDriveById(id);
    }

    @GetMapping
    public List<PlacementDrive> getAllDrives() {
        return placementDriveService.getAllDrives();
    }
}