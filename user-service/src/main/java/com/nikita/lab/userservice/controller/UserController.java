package com.nikita.lab.userservice.controller;

import com.nikita.lab.userservice.model.User;
import com.nikita.lab.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        logger.info("Instance {} обработал GET /api/users", instanceId);
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        logger.info("Instance {} Обработал POST /api/users", instanceId);
        User createdUser = userService.createUser(user);
        URI location = URI.create("/api/users/" + createdUser.getId());

        return ResponseEntity
                .created(location) // автоматически ставит статус код 201
                .body(createdUser);
    }
}
