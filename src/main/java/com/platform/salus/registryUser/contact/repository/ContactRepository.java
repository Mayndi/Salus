package com.platform.salus.registryUser.contact.repository;

import com.platform.salus.registryUser.contact.model.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
}
