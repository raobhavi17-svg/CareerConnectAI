package com.careerconnect.repository;

import com.careerconnect.model.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository {

    Company save(Company company);

    Optional<Company> findById(String companyId);

    List<Company> findAll();

}