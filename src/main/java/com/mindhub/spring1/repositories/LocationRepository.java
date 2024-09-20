package com.mindhub.spring1.repositories;

import com.mindhub.spring1.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocationRepository extends JpaRepository<Location, UUID> {
}
