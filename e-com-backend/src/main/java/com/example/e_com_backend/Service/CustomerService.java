package com.example.e_com_backend.Service;

import com.example.e_com_backend.Entity.Customer;
import com.example.e_com_backend.Repository.CustomerRepository;
import com.example.e_com_backend.config.JwtUtil;
import com.example.e_com_backend.dto.AuthResponse;
import com.example.e_com_backend.dto.CustomerLoginRequest;
import com.example.e_com_backend.dto.CustomerRegisterRequest;
import com.example.e_com_backend.dto.UserPayload;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService  {
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
