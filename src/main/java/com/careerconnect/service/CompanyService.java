package com.careerconnect.service;

import com.careerconnect.model.entity.Company;

import java.util.List;

public interface CompanyService {

    Company registerCompany(Company company);

    Company getCompanyById(String companyId);

    List<Company> getAllCompanies();
}