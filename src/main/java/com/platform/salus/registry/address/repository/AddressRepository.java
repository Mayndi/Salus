package com.platform.salus.registry.address.repository;

import com.platform.salus.registry.address.model.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
