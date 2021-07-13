package com.nanos.test.model.repository;

import com.nanos.test.model.Assessment;
import com.nanos.test.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessmentRepository extends CrudRepository<Assessment,Long> {
    public List<Assessment> findAssessmentsByOwner(User owner);
}
