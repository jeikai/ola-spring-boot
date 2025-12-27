package com.example.buoi4.controller;

import com.example.buoi4.dto.RegisterRequest;
import com.example.buoi4.model.User;
import com.example.buoi4.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/user")
public class UserController {
    private UserService userService;

    @PostMapping()
    public User register(@RequestBody RegisterRequest body) {
        return userService.register(body);
    }
}
