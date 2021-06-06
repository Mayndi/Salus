package com.platform.salus.registryUser.user.repository;

import com.platform.salus.registryUser.user.model.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmailAndSenha(String email, String senha);
}
