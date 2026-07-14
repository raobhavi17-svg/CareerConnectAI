package com.careerconnect.repository;

import com.careerconnect.model.entity.Application;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository {

    Application save(Application application);

    Optional<Application> findById(String applicationId);

    List<Application> findAll();

}
