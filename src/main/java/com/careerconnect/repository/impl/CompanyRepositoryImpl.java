package com.careerconnect.repository.impl;

import com.careerconnect.model.entity.Company;
import com.careerconnect.repository.CompanyRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {

    private final Map<String, Company> companies = new HashMap<>();

    @Override
    public Company save(Company company) {
        companies.put(company.getCompanyId(), company);
        return company;
    }

    @Override
    public Optional<Company> findById(String companyId) {
        return Optional.ofNullable(companies.get(companyId));
    }

    @Override
    public List<Company> findAll() {
        return new ArrayList<>(companies.values());
    }
}