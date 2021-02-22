package com.platform.salus.registryUser.user.repository;

import com.platform.salus.registryUser.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
