package com.nanos.test.controller;

import com.nanos.test.model.User;
import com.nanos.test.requestbody.LoginRequest;
import com.nanos.test.responsebody.JwtResposne;
import com.nanos.test.service.UserService;
import com.nanos.test.serviceimpl.MyUserDetails;
import com.nanos.test.serviceimpl.MyUserDetailsService;
import com.nanos.test.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.nanos.test.constants.SecurityConstants.SIGN_IN_URL;
import static com.nanos.test.constants.SecurityConstants.SIGN_UP_URL;

@RestController
@AllArgsConstructor

public class UserController {
    private UserService userService;
    AuthenticationManager authenticationManager;
    PasswordEncoder encoder;
    JwtUtil jwtUtil;
    MyUserDetailsService myUserDetailsService;
    @GetMapping(value="/allstudent")
    public String getAllStudent(){
        return "jj";
    }

    @GetMapping(value="/alluser")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(value = SIGN_UP_URL)
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }
    @PostMapping(value = SIGN_IN_URL)
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = myUserDetailsService.loadUserByUsername(loginRequest.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        String body = ((MyUserDetails)authentication.getPrincipal()).getUsername() + " "+token;
        JwtResposne jwtResposne =new JwtResposne(token);

        return ResponseEntity.ok(jwtResposne);
    }
}
