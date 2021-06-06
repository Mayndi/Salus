package com.platform.salus.registryUser.medic.repository;

import com.platform.salus.registryUser.medic.converter.output.MedicOutput;
import com.platform.salus.registryUser.medic.model.MedicEntity;
import com.platform.salus.registryUser.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicRepository extends JpaRepository<MedicEntity, Long> {
    MedicEntity findByUser(UserEntity user);
}
