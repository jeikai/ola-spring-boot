package com.example.buoi4.service;

import com.example.buoi4.config.JwtUtil;
import com.example.buoi4.dto.AuthResponse;
import com.example.buoi4.dto.CustomerLoginRequest;
import com.example.buoi4.dto.UserPayload;
import com.example.buoi4.model.Customer;
import com.example.buoi4.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthResponse login(CustomerLoginRequest request) {
        Customer customer = customerRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!customer.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        UserPayload payload = new UserPayload(customer.getFirstName() + " " + customer.getLastName(), customer.getCustomerEmail(), customer.getCustomerId());
        String token = jwtUtil.generateToken(payload);

        return new AuthResponse(token, customer.getFirstName() + " " + customer.getLastName(), customer.getCustomerEmail(), customer.getCustomerId());
    }
}
