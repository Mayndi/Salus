package com.platform.salus.registryUser.medic.repository;

import com.platform.salus.registryUser.medic.model.MedicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicRepository extends JpaRepository<MedicEntity, Long> {
}
