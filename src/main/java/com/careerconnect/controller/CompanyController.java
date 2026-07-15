package com.careerconnect.controller;

import com.careerconnect.dto.request.CompanyRequest;
import com.careerconnect.dto.response.CompanyResponse;
import com.careerconnect.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<CompanyResponse> registerCompany(
            @Valid @RequestBody CompanyRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(companyService.registerCompany(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponse> getCompany(
            @PathVariable String id) {

        return ResponseEntity.ok(companyService.getCompanyById(id));
    }

    @GetMapping
    public ResponseEntity<List<CompanyResponse>> getAllCompanies() {

        return ResponseEntity.ok(companyService.getAllCompanies());
    }
}
