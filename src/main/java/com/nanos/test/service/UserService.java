package com.nanos.test.service;

import com.nanos.test.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public void saveUser(User user);
}
