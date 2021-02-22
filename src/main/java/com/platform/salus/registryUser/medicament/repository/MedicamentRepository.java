package com.platform.salus.registryUser.medicament.repository;

import com.platform.salus.registryUser.medicament.model.MedicamentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentRepository extends JpaRepository<MedicamentEntity, Long> {
}
