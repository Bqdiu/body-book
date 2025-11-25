package com.bodybook.backend.service;

import com.bodybook.backend.dto.UserRequest;
import com.bodybook.backend.exception.BadRequestException;
import com.bodybook.backend.model.User;
import com.bodybook.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(UserRequest request) {
        if(userRepository.existsByEmail(request.getEmail()))
            throw new BadRequestException("Email already exists");

        if(userRepository.existsByUsername(request.getUsername()))
            throw new BadRequestException("Username already exists");

        User user = new User();
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        return userRepository.save(user);
    }
}
