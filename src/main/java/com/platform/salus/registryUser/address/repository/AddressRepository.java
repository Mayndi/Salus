package com.platform.salus.registryUser.address.repository;

import com.platform.salus.registryUser.address.model.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
