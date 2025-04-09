package com.nikita.lab.userservice.service;

import com.nikita.lab.userservice.model.User;
import com.nikita.lab.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }
}
