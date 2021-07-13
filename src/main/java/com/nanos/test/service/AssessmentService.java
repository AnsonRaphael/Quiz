package com.nanos.test.service;

import com.nanos.test.model.Assessment;
import com.nanos.test.model.User;

import java.util.List;

public interface AssessmentService {
    public void saveAssessment(Assessment assessment);
    public List<Assessment> getAllUserAssessments(User owner);
}
