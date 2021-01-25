package com.platform.salus.registry.medic.repository;

import com.platform.salus.registry.medic.model.MedicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicRepository extends JpaRepository<MedicEntity, Long> {
}
