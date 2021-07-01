package com.nanos.test.controller;

import com.nanos.test.model.User;
import com.nanos.test.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor

public class StudentController {
    private UserService userService;

    @GetMapping(value="/allstudent")
    public String getAllStudent(){
        return "jj";
    }

    @GetMapping(value="/alluser")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(value = "user")
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }
}
