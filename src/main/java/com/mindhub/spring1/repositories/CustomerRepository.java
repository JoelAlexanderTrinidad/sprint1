package com.mindhub.spring1.repositories;

import com.mindhub.spring1.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
