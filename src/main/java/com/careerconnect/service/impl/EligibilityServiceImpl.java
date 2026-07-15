package com.careerconnect.service.impl;

import com.careerconnect.model.entity.PlacementDrive;
import com.careerconnect.model.entity.Student;
import com.careerconnect.service.EligibilityService;
import com.careerconnect.strategy.impl.BacklogEligibilityStrategy;
import com.careerconnect.strategy.impl.CgpaEligibilityStrategy;
import com.careerconnect.strategy.impl.SkillEligibilityStrategy;
import org.springframework.stereotype.Service;

@Service
public class EligibilityServiceImpl implements EligibilityService {

    private final CgpaEligibilityStrategy cgpaStrategy;
    private final BacklogEligibilityStrategy backlogStrategy;
    private final SkillEligibilityStrategy skillStrategy;

    public EligibilityServiceImpl(
            CgpaEligibilityStrategy cgpaStrategy,
            BacklogEligibilityStrategy backlogStrategy,
            SkillEligibilityStrategy skillStrategy) {

        this.cgpaStrategy = cgpaStrategy;
        this.backlogStrategy = backlogStrategy;
        this.skillStrategy = skillStrategy;
    }

    @Override
    public boolean checkEligibility(Student student, PlacementDrive drive) {

        return cgpaStrategy.isEligible(student, drive)
                && backlogStrategy.isEligible(student, drive)
                && skillStrategy.isEligible(student, drive);
    }
}