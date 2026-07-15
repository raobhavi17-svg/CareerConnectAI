package com.careerconnect.service;

import com.careerconnect.model.entity.PlacementDrive;
import com.careerconnect.model.entity.Student;

public interface EligibilityService {

    boolean checkEligibility(Student student, PlacementDrive drive);
}
