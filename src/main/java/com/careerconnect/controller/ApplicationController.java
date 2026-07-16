package com.careerconnect.controller;

import com.careerconnect.dto.request.ApplicationRequest;
import com.careerconnect.dto.response.ApplicationResponse;
import com.careerconnect.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Application API",
        description = "Operations related to placement applications"
)
@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }
    @Operation(summary = "Apply for a placement drive")

    @PostMapping
    public ResponseEntity<ApplicationResponse> apply(
            @Valid @RequestBody ApplicationRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(applicationService.apply(request));
    }
    @Operation(summary = "Get application by ID")

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationResponse> getApplication(
            @PathVariable String id) {

        return ResponseEntity.ok(
                applicationService.getApplicationById(id)
        );
    }
    @Operation(summary = "Get all applications")

    @GetMapping
    public ResponseEntity<List<ApplicationResponse>> getAllApplications() {

        return ResponseEntity.ok(
                applicationService.getAllApplications()
        );
    }
}