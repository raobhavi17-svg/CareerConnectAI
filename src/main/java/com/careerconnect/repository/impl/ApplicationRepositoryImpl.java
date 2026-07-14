package com.careerconnect.repository.impl;

import com.careerconnect.model.entity.Application;
import com.careerconnect.repository.ApplicationRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ApplicationRepositoryImpl implements ApplicationRepository {

    private final Map<String, Application> applications = new HashMap<>();

    @Override
    public Application save(Application application) {
        applications.put(application.getApplicationId(), application);
        return application;
    }

    @Override
    public Optional<Application> findById(String applicationId) {
        return Optional.ofNullable(applications.get(applicationId));
    }

    @Override
    public List<Application> findAll() {
        return new ArrayList<>(applications.values());
    }
}