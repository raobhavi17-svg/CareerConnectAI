package com.careerconnect.service.impl;

import com.careerconnect.dto.request.ApplicationRequest;
import com.careerconnect.dto.response.ApplicationResponse;
import com.careerconnect.exception.ApplicationNotFoundException;
import com.careerconnect.exception.DuplicateApplicationException;
import com.careerconnect.exception.PlacementDriveNotFoundException;
import com.careerconnect.exception.StudentNotFoundException;
import com.careerconnect.mapper.ApplicationMapper;
import com.careerconnect.model.entity.Application;
import com.careerconnect.model.entity.PlacementDrive;
import com.careerconnect.model.entity.Student;
import com.careerconnect.model.enums.ApplicationStatus;
import com.careerconnect.repository.ApplicationRepository;
import com.careerconnect.repository.PlacementDriveRepository;
import com.careerconnect.repository.StudentRepository;
import com.careerconnect.service.ApplicationService;
import org.springframework.stereotype.Service;
import com.careerconnect.service.EligibilityService;
import com.careerconnect.exception.StudentNotEligibleException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final StudentRepository studentRepository;
    private final PlacementDriveRepository placementDriveRepository;
    private final ApplicationMapper applicationMapper;
    private final EligibilityService eligibilityService;

    public ApplicationServiceImpl(
            ApplicationRepository applicationRepository,
            StudentRepository studentRepository,
            PlacementDriveRepository placementDriveRepository,
            ApplicationMapper applicationMapper,
            EligibilityService eligibilityService) {

        this.applicationRepository = applicationRepository;
        this.studentRepository = studentRepository;
        this.placementDriveRepository = placementDriveRepository;
        this.applicationMapper = applicationMapper;
        this.eligibilityService = eligibilityService;
    }

    @Override
    public ApplicationResponse apply(ApplicationRequest request) {

        applicationRepository.findById(request.getApplicationId())
                .ifPresent(app -> {
                    throw new DuplicateApplicationException("Application already exists.");
                });

        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found"));

        PlacementDrive drive = placementDriveRepository.findById(request.getDriveId())
                .orElseThrow(() ->
                        new PlacementDriveNotFoundException("Placement Drive not found"));
        if (!eligibilityService.checkEligibility(student, drive)) {
            throw new StudentNotEligibleException(
                    "Student is not eligible for this placement drive.");
        }


        Application application = Application.builder()
                .applicationId(request.getApplicationId())
                .student(student)
                .placementDrive(drive)
                .appliedOn(LocalDateTime.now())
                .status(ApplicationStatus.SUBMITTED)
                .build();

        return applicationMapper.toResponse(
                applicationRepository.save(application)
        );
    }

    @Override
    public ApplicationResponse getApplicationById(String applicationId) {

        return applicationMapper.toResponse(
                applicationRepository.findById(applicationId)
                        .orElseThrow(() ->
                                new ApplicationNotFoundException("Application not found"))
        );
    }

    @Override
    public List<ApplicationResponse> getAllApplications() {

        return applicationRepository.findAll()
                .stream()
                .map(applicationMapper::toResponse)
                .collect(Collectors.toList());
    }

}