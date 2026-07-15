package com.careerconnect.strategy.impl;

import com.careerconnect.model.entity.PlacementDrive;
import com.careerconnect.model.entity.Student;
import com.careerconnect.strategy.EligibilityStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SkillEligibilityStrategy implements EligibilityStrategy {

    @Override
    public boolean isEligible(Student student, PlacementDrive drive) {

        List<String> studentSkills = student.getSkills();
        List<String> requiredSkills = drive.getRequiredSkills();

        return studentSkills.containsAll(requiredSkills);
    }
}
