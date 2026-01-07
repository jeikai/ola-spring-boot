package com.example.buoi4.service;

import com.example.buoi4.dto.RegisterRequest;
import com.example.buoi4.dto.UpdateRequest;
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

    public User createUser(RegisterRequest body) {
        User user = new User(body.username, body.email, body.password);

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        Optional<User> response = userRepository.findById(id);

        if(response.isEmpty()) {
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
