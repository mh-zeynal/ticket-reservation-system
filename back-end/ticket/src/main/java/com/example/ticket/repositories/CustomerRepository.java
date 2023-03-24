package com.example.ticket.repositories;

import com.example.ticket.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer getCustomerByUserUsername(String username);

    Customer getByCustomerId(Long customerId);
}
