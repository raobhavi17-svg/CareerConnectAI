package com.careerconnect.strategy;

import com.careerconnect.model.entity.PlacementDrive;
import com.careerconnect.model.entity.Student;

public interface EligibilityStrategy {

    boolean isEligible(Student student, PlacementDrive drive);

}
