package com.platform.salus.registryHospital.information.repository;

import com.platform.salus.registryHospital.information.model.HospitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<HospitalEntity, Long> {
}
