package com.mindhub.spring1.repositories;

import com.mindhub.spring1.models.CustomerEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerEventRepository extends JpaRepository<CustomerEvent, UUID> {
}
