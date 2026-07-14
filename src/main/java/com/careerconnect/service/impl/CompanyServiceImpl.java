package com.careerconnect.service.impl;

import com.careerconnect.model.entity.Company;
import com.careerconnect.repository.CompanyRepository;
import com.careerconnect.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company registerCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(String companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found"));
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
