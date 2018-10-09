package com.omnia.users.service;

import com.omnia.users.exceptions.NotFoundException;
import com.omnia.users.model.entities.UserEntity;
import com.omnia.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    public Collection<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User with id [" + userId + "] was not found!"));
    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    public void delete(UserEntity user) {
        userRepository.delete(user);
    }

}
