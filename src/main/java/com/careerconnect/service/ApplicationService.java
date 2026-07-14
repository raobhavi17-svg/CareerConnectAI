package com.careerconnect.service;

import com.careerconnect.model.entity.Application;

import java.util.List;

public interface ApplicationService {

    Application apply(Application application);

    Application getApplicationById(String applicationId);

    List<Application> getAllApplications();
}