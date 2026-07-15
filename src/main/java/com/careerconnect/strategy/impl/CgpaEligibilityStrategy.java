package com.careerconnect.strategy.impl;

import com.careerconnect.model.entity.PlacementDrive;
import com.careerconnect.model.entity.Student;
import com.careerconnect.strategy.EligibilityStrategy;
import org.springframework.stereotype.Component;

@Component
public class CgpaEligibilityStrategy implements EligibilityStrategy {

    @Override
    public boolean isEligible(Student student, PlacementDrive drive) {
        return student.getCgpa() >= drive.getMinimumCgpa();
    }
}