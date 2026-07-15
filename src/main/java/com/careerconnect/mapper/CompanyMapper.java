package com.careerconnect.mapper;

import com.careerconnect.dto.request.CompanyRequest;
import com.careerconnect.dto.response.CompanyResponse;
import com.careerconnect.model.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public Company toEntity(CompanyRequest request) {

        return Company.builder()
                .companyId(request.getCompanyId())
                .companyName(request.getCompanyName())
                .industry(request.getIndustry())
                .location(request.getLocation())
                .minimumCgpa(request.getMinimumCgpa())
                .maximumBacklogs(request.getMaximumBacklogs())
                .build();
    }

    public CompanyResponse toResponse(Company company) {

        return CompanyResponse.builder()
                .companyId(company.getCompanyId())
                .companyName(company.getCompanyName())
                .industry(company.getIndustry())
                .location(company.getLocation())
                .minimumCgpa(company.getMinimumCgpa())
                .maximumBacklogs(company.getMaximumBacklogs())
                .build();
    }
}