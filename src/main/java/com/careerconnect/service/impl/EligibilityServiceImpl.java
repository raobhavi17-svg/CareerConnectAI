package com.careerconnect.service.impl;

import com.careerconnect.model.entity.PlacementDrive;
import com.careerconnect.model.entity.Student;
import com.careerconnect.service.EligibilityService;
import com.careerconnect.strategy.EligibilityStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EligibilityServiceImpl implements EligibilityService {

    private final List<EligibilityStrategy> strategies;

    public EligibilityServiceImpl(List<EligibilityStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public boolean checkEligibility(Student student, PlacementDrive drive) {

        for (EligibilityStrategy strategy : strategies) {

            if (!strategy.isEligible(student, drive)) {
                return false;
            }

        }

        return true;
    }
}