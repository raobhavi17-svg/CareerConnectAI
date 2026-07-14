package com.careerconnect.service.impl;

import com.careerconnect.model.entity.Application;
import com.careerconnect.repository.ApplicationRepository;
import com.careerconnect.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Application apply(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public Application getApplicationById(String applicationId) {
        return applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found"));
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }
}