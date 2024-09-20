package com.mindhub.spring1.repositories;

import com.mindhub.spring1.models.EventLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventLocationRepository extends JpaRepository<EventLocation, UUID> {
}