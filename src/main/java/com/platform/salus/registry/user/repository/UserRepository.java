package com.platform.salus.registry.user.repository;

import com.platform.salus.registry.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
