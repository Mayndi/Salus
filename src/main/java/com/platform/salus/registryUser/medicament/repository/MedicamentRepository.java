package com.platform.salus.registryUser.medicament.repository;

import com.platform.salus.registryUser.medicament.converter.output.MedicamentOutput;
import com.platform.salus.registryUser.medicament.model.MedicamentEntity;
import com.platform.salus.registryUser.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentRepository extends JpaRepository<MedicamentEntity, Long> {
    MedicamentEntity findByUser(UserEntity user);
}
