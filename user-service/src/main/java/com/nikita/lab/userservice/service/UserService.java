package com.nikita.lab.userservice.service;

import com.nikita.lab.userservice.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User createUser(User user);
}
