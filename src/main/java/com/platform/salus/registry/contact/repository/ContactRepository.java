package com.platform.salus.registry.contact.repository;

import com.platform.salus.registry.contact.model.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
}
