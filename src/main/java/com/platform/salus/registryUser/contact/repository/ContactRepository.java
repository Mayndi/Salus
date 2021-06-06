package com.platform.salus.registryUser.contact.repository;

import com.platform.salus.registryUser.contact.converter.output.ContactOutput;
import com.platform.salus.registryUser.contact.model.ContactEntity;
import com.platform.salus.registryUser.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
    ContactEntity findByUser(UserEntity user);
}
