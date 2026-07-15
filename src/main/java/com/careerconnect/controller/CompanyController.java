package com.careerconnect.controller;

import com.careerconnect.model.entity.Company;
import com.careerconnect.service.CompanyService;
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
    public Company registerCompany(@RequestBody Company company) {
        return companyService.registerCompany(company);
    }

    @GetMapping("/{id}")
    public Company getCompany(@PathVariable String id) {
        return companyService.getCompanyById(id);
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }
}
