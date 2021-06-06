package com.platform.salus.registryUser.address.repository;

import com.platform.salus.registryUser.address.converter.output.AddressOutput;
import com.platform.salus.registryUser.address.model.AddressEntity;
import com.platform.salus.registryUser.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
    AddressEntity findByUser(UserEntity user);
}
