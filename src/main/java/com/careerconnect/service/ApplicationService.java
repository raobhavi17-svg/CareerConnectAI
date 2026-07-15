package com.careerconnect.service;

import com.careerconnect.dto.request.ApplicationRequest;
import com.careerconnect.dto.response.ApplicationResponse;

import java.util.List;

public interface ApplicationService {

    ApplicationResponse apply(ApplicationRequest request);

    ApplicationResponse getApplicationById(String applicationId);

    List<ApplicationResponse> getAllApplications();
}