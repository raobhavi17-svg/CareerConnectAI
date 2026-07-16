package com.careerconnect.controller;

import com.careerconnect.dto.request.PlacementDriveRequest;
import com.careerconnect.dto.response.PlacementDriveResponse;
import com.careerconnect.service.PlacementDriveService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Placement Drive API",
        description = "Operations related to placement drives"
)
@RestController
@RequestMapping("/drives")
public class PlacementDriveController {

    private final PlacementDriveService placementDriveService;

    public PlacementDriveController(PlacementDriveService placementDriveService) {
        this.placementDriveService = placementDriveService;
    }
    @Operation(summary = "Create a new placement drive")

    @PostMapping
    public ResponseEntity<PlacementDriveResponse> createDrive(
            @Valid @RequestBody PlacementDriveRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(placementDriveService.createDrive(request));
    }
    @Operation(summary = "Get placement drive by ID")

    @GetMapping("/{id}")
    public ResponseEntity<PlacementDriveResponse> getDrive(@PathVariable String id) {

        return ResponseEntity.ok(
                placementDriveService.getDriveById(id)
        );
    }
    @Operation(summary = "Get all placement drives")

    @GetMapping
    public ResponseEntity<List<PlacementDriveResponse>> getAllDrives() {

        return ResponseEntity.ok(
                placementDriveService.getAllDrives()
        );
    }
}