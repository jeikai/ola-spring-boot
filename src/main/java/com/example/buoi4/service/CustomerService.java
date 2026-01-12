package com.example.buoi4.service;

import com.example.buoi4.config.JwtUtil;
import com.example.buoi4.dto.AuthResponse;
import com.example.buoi4.dto.CustomerLoginRequest;
import com.example.buoi4.dto.CustomerRegisterRequest;
import com.example.buoi4.dto.UserPayload;
import com.example.buoi4.model.Customer;
import com.example.buoi4.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    public AuthResponse registerCustomer(CustomerRegisterRequest request) {
        // Check if email already exists
        if (customerRepository.existsByCustomerEmail(request.getCustomerEmail())) {
            throw new RuntimeException("Email already exists");
        }
        
        // Create new customer
        Customer customer = new Customer(
            request.getCustomerEmail(),
            request.getFirstName(),
            request.getLastName(),
            request.getPassword()
        );
        customer.setAddress(request.getAddress());
        customer.setCity(request.getCity());
        customer.setPostcode(request.getPostcode());
        customer.setPhone(request.getPhone());
        
        Customer savedCustomer = customerRepository.save(customer);
        
        // Generate JWT token
        UserPayload payload = new UserPayload(
            savedCustomer.getFirstName() + " " + savedCustomer.getLastName(),
            savedCustomer.getCustomerEmail(),
            savedCustomer.getCustomerId()
        );
        String token = jwtUtil.generateToken(payload);
        
        return new AuthResponse(
            token,
            savedCustomer.getFirstName() + " " + savedCustomer.getLastName(),
            savedCustomer.getCustomerEmail(),
            savedCustomer.getCustomerId()
        );
    }
    
    public AuthResponse loginCustomer(CustomerLoginRequest request) {
        // Find customer by email
        Customer customer = customerRepository.findByCustomerEmail(request.getCustomerEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
        
        // Check password (in production, use password encoding)
        if (!customer.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }
        
        // Generate JWT token
        UserPayload payload = new UserPayload(
            customer.getFirstName() + " " + customer.getLastName(),
            customer.getCustomerEmail(),
            customer.getCustomerId()
        );
        String token = jwtUtil.generateToken(payload);
        
        return new AuthResponse(
            token,
            customer.getFirstName() + " " + customer.getLastName(),
            customer.getCustomerEmail(),
            customer.getCustomerId()
        );
    }
    
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    public Customer getCustomerById(int customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
    
    public Customer updateCustomer(int customerId, CustomerRegisterRequest request) {
        Customer customer = getCustomerById(customerId);
        
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setAddress(request.getAddress());
        customer.setCity(request.getCity());
        customer.setPostcode(request.getPostcode());
        customer.setPhone(request.getPhone());
        
        return customerRepository.save(customer);
    }
    
    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }
    
    public List<Customer> searchCustomersByName(String name) {
        return customerRepository.findByName(name);
    }
    
    public List<Customer> getCustomersByCity(String city) {
        return customerRepository.findByCity(city);
    }
}