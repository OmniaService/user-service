package com.omnia.users.controller;

import com.omnia.users.model.User;
import com.omnia.users.model.entities.UserEntity;
import com.omnia.users.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://localhost:4200")
@RefreshScope
@RestController
@RequestMapping(value = "/", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User save(@RequestBody User user) {
        log.debug("Attempting to save user: " + user);
        User savedUser = userService.saveUser(user.convertToEntity()).convertToDTO();
        log.debug("User saved: " + savedUser);
        return savedUser;
    }

    @GetMapping("/")
    public List<User> getAll() {
        log.debug("Fetching all users...");
        return userService.findAll().stream().map(UserEntity::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{userId}")
    public User getById(@PathVariable("userId") Long userId) {
        log.debug("Fetching user with id: " + userId);
        return userService.findUserById(userId).convertToDTO();
    }

    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable("userId") Long userId) {
        log.debug("Deleting user with id: " + userId);
        userService.deleteById(userId);
    }

    @DeleteMapping("/")
    public void deleteByEntity(@RequestBody User user) {
        log.debug("Deleting user: " + user);
        userService.delete(user.convertToEntity());
    }

}
