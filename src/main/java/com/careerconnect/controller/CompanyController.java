package com.careerconnect.controller;

import com.careerconnect.dto.request.CompanyRequest;
import com.careerconnect.dto.response.CompanyResponse;
import com.careerconnect.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Company API",
        description = "Operations related to company management"
)
@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @Operation(summary = "Register a new company")

    @PostMapping
    public ResponseEntity<CompanyResponse> registerCompany(
            @Valid @RequestBody CompanyRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(companyService.registerCompany(request));
    }
    @Operation(summary = "Get company by ID")

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponse> getCompany(
            @PathVariable String id) {

        return ResponseEntity.ok(companyService.getCompanyById(id));
    }
    @Operation(summary = "Get all companies")

    @GetMapping
    public ResponseEntity<List<CompanyResponse>> getAllCompanies() {

        return ResponseEntity.ok(companyService.getAllCompanies());
    }
}
