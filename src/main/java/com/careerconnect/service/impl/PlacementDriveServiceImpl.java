package com.careerconnect.service.impl;

import com.careerconnect.dto.request.PlacementDriveRequest;
import com.careerconnect.dto.response.PlacementDriveResponse;
import com.careerconnect.exception.CompanyNotFoundException;
import com.careerconnect.exception.DuplicatePlacementDriveException;
import com.careerconnect.exception.PlacementDriveNotFoundException;
import com.careerconnect.mapper.PlacementDriveMapper;
import com.careerconnect.model.entity.Company;
import com.careerconnect.model.entity.PlacementDrive;
import com.careerconnect.repository.CompanyRepository;
import com.careerconnect.repository.PlacementDriveRepository;
import com.careerconnect.service.PlacementDriveService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlacementDriveServiceImpl implements PlacementDriveService {

    private final PlacementDriveRepository placementDriveRepository;
    private final CompanyRepository companyRepository;
    private final PlacementDriveMapper placementDriveMapper;

    public PlacementDriveServiceImpl(
            PlacementDriveRepository placementDriveRepository,
            CompanyRepository companyRepository,
            PlacementDriveMapper placementDriveMapper) {

        this.placementDriveRepository = placementDriveRepository;
        this.companyRepository = companyRepository;
        this.placementDriveMapper = placementDriveMapper;
    }

    @Override
    public PlacementDriveResponse createDrive(PlacementDriveRequest request) {

        placementDriveRepository.findById(request.getDriveId())
                .ifPresent(drive -> {
                    throw new DuplicatePlacementDriveException("Placement Drive already exists.");
                });

        Company company = companyRepository.findById(request.getCompanyId())
                .orElseThrow(() ->
                        new CompanyNotFoundException("Company not found"));

        PlacementDrive drive = PlacementDrive.builder()
                .driveId(request.getDriveId())
                .title(request.getTitle())
                .company(company)
                .driveDate(request.getDriveDate())
                .requiredSkills(request.getRequiredSkills())
                .minimumCgpa(request.getMinimumCgpa())
                .maximumBacklogs(request.getMaximumBacklogs())
                .status(request.getStatus())
                .build();

        return placementDriveMapper.toResponse(
                placementDriveRepository.save(drive)
        );
    }

    @Override
    public PlacementDriveResponse getDriveById(String driveId) {

        PlacementDrive drive = placementDriveRepository.findById(driveId)
                .orElseThrow(() ->
                        new PlacementDriveNotFoundException("Placement Drive not found"));

        return placementDriveMapper.toResponse(drive);
    }

    @Override
    public List<PlacementDriveResponse> getAllDrives() {

        return placementDriveRepository.findAll()
                .stream()
                .map(placementDriveMapper::toResponse)
                .collect(Collectors.toList());
    }
}
