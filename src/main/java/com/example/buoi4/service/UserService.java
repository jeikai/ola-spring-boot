package com.example.buoi4.service;

import com.example.buoi4.config.JwtUtil;
import com.example.buoi4.dto.AuthResponse;
import com.example.buoi4.dto.LoginRequest;
import com.example.buoi4.dto.RegisterRequest;
import com.example.buoi4.dto.UpdateRequest;
import com.example.buoi4.dto.UserPayload;
import com.example.buoi4.model.User;
import com.example.buoi4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthResponse register(RegisterRequest body) {
        // Check if email already exists
        if (userRepository.existsByEmail(body.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // Create new user
        User user = new User(body.getUsername(), body.getEmail(), body.getPassword());
        User savedUser = userRepository.save(user);

        // Generate token
        UserPayload payload = new UserPayload(savedUser.getUsername(), savedUser.getEmail(), savedUser.getId());
        String token = jwtUtil.generateToken(payload);

        return new AuthResponse(token, savedUser.getUsername(), savedUser.getEmail(), savedUser.getId());
    }

    public AuthResponse login(LoginRequest body) {
        // Find user by email
        User user = userRepository.findByEmail(body.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        // Check password (in production, you should use password encoding)
        if (!user.getPassword().equals(body.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        // Generate token
        UserPayload payload = new UserPayload(user.getUsername(), user.getEmail(), user.getId());
        String token = jwtUtil.generateToken(payload);

        return new AuthResponse(token, user.getUsername(), user.getEmail(), user.getId());
    }

    public User createUser(RegisterRequest body) {
        User user = new User(body.getUsername(), body.getEmail(), body.getPassword());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        Optional<User> response = userRepository.findById(id);

        if (response.isEmpty()) {
            throw new RuntimeException("Can not find user");
        }

        return response.get();
    }

    public User updateUserById(int id, UpdateRequest body) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cannot find user"));

        user.setUsername(body.getUsername());
        user.setEmail(body.getEmail());
        user.setPassword(body.getPassword());

        return userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
