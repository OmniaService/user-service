package com.omnia.users.service;

import com.omnia.users.exceptions.AlreadyExistsException;
import com.omnia.users.exceptions.NotFoundException;
import com.omnia.users.model.entities.UserEntity;
import com.omnia.users.repository.UserRepository;
import com.omnia.users.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity saveUser(UserEntity user) {
        Validator.validateUser(user);
        if (!userRepository.existsByUsername(user.getUsername())) {
            return userRepository.save(user);
        } else {
            throw new AlreadyExistsException("User with username: " + user.getUsername() + " already taken!");
        }
    }

    public Collection<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User with id: " + userId.toString() + " not found"));
    }

    public void deleteById(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
        } else {
            throw new NotFoundException("User with id: " + userId.toString() + " not found");
        }
    }

    public void delete(UserEntity user) {
        if (userRepository.existsById(user.getId())) {
            userRepository.delete(user);
        } else {
            throw new NotFoundException("User: " + user + " not found");
        }
    }
}
