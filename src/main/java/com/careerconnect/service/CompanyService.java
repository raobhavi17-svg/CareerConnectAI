package com.careerconnect.service;

import com.careerconnect.dto.request.CompanyRequest;
import com.careerconnect.dto.response.CompanyResponse;

import java.util.List;

public interface CompanyService {

    CompanyResponse registerCompany(CompanyRequest request);

    CompanyResponse getCompanyById(String companyId);

    List<CompanyResponse> getAllCompanies();
}