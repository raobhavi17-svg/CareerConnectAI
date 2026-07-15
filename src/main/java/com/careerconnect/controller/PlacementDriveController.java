package com.careerconnect.controller;

import com.careerconnect.dto.request.PlacementDriveRequest;
import com.careerconnect.dto.response.PlacementDriveResponse;
import com.careerconnect.service.PlacementDriveService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<PlacementDriveResponse> createDrive(
            @Valid @RequestBody PlacementDriveRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(placementDriveService.createDrive(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlacementDriveResponse> getDrive(@PathVariable String id) {

        return ResponseEntity.ok(
                placementDriveService.getDriveById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<PlacementDriveResponse>> getAllDrives() {

        return ResponseEntity.ok(
                placementDriveService.getAllDrives()
        );
    }
}