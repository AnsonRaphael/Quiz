package com.nanos.test.controller;

import com.nanos.test.model.Assessment;
import com.nanos.test.model.User;
import com.nanos.test.service.AssessmentService;
import com.nanos.test.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("assessment")
@AllArgsConstructor
public class AssessmentController {

    AssessmentService assessmentService;
    UserService userService;
    @PostMapping(value = "/save")
    public void saveUser(@RequestBody Assessment assessment, Principal principal){
        String userName=principal.getName();
        User user = userService.getByUsername(userName);
        assessment.setOwner(user);
        assessmentService.saveAssessment(assessment);
    }
    // remove - not needed
    @GetMapping(value = "/get-all-user-assessment")
    public List<Assessment> getAllUserAssessments(Principal principal){
        String userName=principal.getName();
        User user = userService.getByUsername(userName);
        return assessmentService.getAllUserAssessments(user);
    }

}
