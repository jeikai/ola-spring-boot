package com.example.buoi4.repository;

import com.example.buoi4.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE c.customerEmail = :email")
    Optional<Customer> findByEmail(@Param("email") String email);

    @Query("SELECT c FROM Customer c WHERE c.firstName LIKE %:name% OR c.lastName LIKE %:name%")
    List<Customer> findByName(@Param("name") String name);
}
