package com.nanos.test.serviceimpl;

import com.nanos.test.model.User;
import com.nanos.test.model.repository.UserRepository;
import com.nanos.test.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers(){
        List<User> userList = (List<User>) userRepository.findAll();
        return userList;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
