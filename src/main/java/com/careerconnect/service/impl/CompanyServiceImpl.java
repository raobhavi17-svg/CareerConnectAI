package com.careerconnect.service.impl;

import com.careerconnect.dto.request.CompanyRequest;
import com.careerconnect.dto.response.CompanyResponse;
import com.careerconnect.exception.CompanyNotFoundException;
import com.careerconnect.exception.DuplicateCompanyException;
import com.careerconnect.mapper.CompanyMapper;
import com.careerconnect.model.entity.Company;
import com.careerconnect.repository.CompanyRepository;
import com.careerconnect.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository,
                              CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    @Override
    public CompanyResponse registerCompany(CompanyRequest request) {

        companyRepository.findById(request.getCompanyId())
                .ifPresent(company -> {
                    throw new DuplicateCompanyException("Company already exists.");
                });

        Company company = companyMapper.toEntity(request);

        return companyMapper.toResponse(
                companyRepository.save(company)
        );
    }

    @Override
    public CompanyResponse getCompanyById(String companyId) {

        Company company = companyRepository.findById(companyId)
                .orElseThrow(() ->
                        new CompanyNotFoundException("Company not found"));

        return companyMapper.toResponse(company);
    }

    @Override
    public List<CompanyResponse> getAllCompanies() {

        return companyRepository.findAll()
                .stream()
                .map(companyMapper::toResponse)
                .collect(Collectors.toList());
    }
}
