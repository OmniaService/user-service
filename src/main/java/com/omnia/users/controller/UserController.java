package com.omnia.users.controller;

import com.omnia.users.model.User;
import com.omnia.users.model.entities.UserEntity;
import com.omnia.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@RefreshScope
@RestController
@RequestMapping(value = "/", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User save(@RequestBody User user){
        return userService.saveUser(user.convertToEntity()).convertToDTO();
    }

    @GetMapping("/")
    public List<User> getAll(){
        return userService.findAll().stream().map(UserEntity::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{userId}")
    public User getById(@PathVariable("userId") Long userId){
        return userService.findUserById(userId).convertToDTO();
    }

    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable("userId") Long userId){
        userService.deleteById(userId);
    }

    @DeleteMapping("/")
    public void deleteById(@RequestBody User user){
        userService.delete(user.convertToEntity());
    }

}
