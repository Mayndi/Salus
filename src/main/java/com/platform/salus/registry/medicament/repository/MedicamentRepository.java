package com.platform.salus.registry.medicament.repository;

import com.platform.salus.registry.medicament.model.MedicamentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentRepository extends JpaRepository<MedicamentEntity, Long> {
}
