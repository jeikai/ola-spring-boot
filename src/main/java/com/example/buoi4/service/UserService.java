package com.example.buoi4.service;

import com.example.buoi4.dto.RegisterRequest;
import com.example.buoi4.model.User;
import com.example.buoi4.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public User register(RegisterRequest body) {
        User user = new User(body.username, body.email, body.password);

        return userRepository.save(user);
    }
}
