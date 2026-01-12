package com.example.buoi4.controller;

import com.example.buoi4.dto.AuthResponse;
import com.example.buoi4.dto.CustomerLoginRequest;
import com.example.buoi4.dto.CustomerRegisterRequest;
import com.example.buoi4.model.Customer;
import com.example.buoi4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin(origins = "*")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registerCustomer(@RequestBody CustomerRegisterRequest request) {
        try {
            AuthResponse response = customerService.registerCustomer(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginCustomer(@RequestBody CustomerLoginRequest request) {
        try {
            AuthResponse response = customerService.loginCustomer(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }
    
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId) {
        try {
            Customer customer = customerService.getCustomerById(customerId);
            return ResponseEntity.ok(customer);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int customerId, 
                                                  @RequestBody CustomerRegisterRequest request) {
        try {
            Customer customer = customerService.updateCustomer(customerId, request);
            return ResponseEntity.ok(customer);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int customerId) {
        try {
            customerService.deleteCustomer(customerId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Customer>> searchCustomers(@RequestParam String name) {
        List<Customer> customers = customerService.searchCustomersByName(name);
        return ResponseEntity.ok(customers);
    }
    
    @GetMapping("/city/{city}")
    public ResponseEntity<List<Customer>> getCustomersByCity(@PathVariable String city) {
        List<Customer> customers = customerService.getCustomersByCity(city);
        return ResponseEntity.ok(customers);
    }
}