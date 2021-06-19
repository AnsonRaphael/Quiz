package com.nanos.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping(value="/allstudent")
    public String getAllStudent(){
        return "jj";
    }
}
