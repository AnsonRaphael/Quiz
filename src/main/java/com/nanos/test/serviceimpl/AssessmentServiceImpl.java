package com.nanos.test.serviceimpl;

import com.nanos.test.model.Assessment;
import com.nanos.test.model.User;
import com.nanos.test.model.repository.AssessmentRepository;
import com.nanos.test.service.AssessmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AssessmentServiceImpl implements AssessmentService {
    private AssessmentRepository assessmentRepository;
    @Override
    public void saveAssessment(Assessment assessment) {

        assessmentRepository.save(assessment);
    }

    @Override
    public List<Assessment> getAllUserAssessments(User owner) {
        List<Assessment> assessments = assessmentRepository.findAssessmentsByOwner(owner);

        return assessmentRepository.findAssessmentsByOwner(owner);
    }
}
