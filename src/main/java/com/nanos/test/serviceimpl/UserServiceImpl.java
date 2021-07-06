package com.nanos.test.serviceimpl;

import com.nanos.test.model.User;
import com.nanos.test.model.repository.UserRepository;
import com.nanos.test.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public List<User> getAllUsers(){
        List<User> userList = (List<User>) userRepository.findAll();
        return userList;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
