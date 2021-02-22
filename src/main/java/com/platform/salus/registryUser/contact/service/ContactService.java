package com.platform.salus.registryUser.contact.service;

import com.platform.salus.common.config.Internationalization;
import com.platform.salus.common.exceptions.InvalidInformationException;
import com.platform.salus.common.exceptions.InvalidPageRequestException;
import com.platform.salus.registryUser.contact.model.ContactEntity;
import com.platform.salus.registryUser.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private static final String MESSAGE_INVALID_CONTACT_INFORMATION_ID = "invalid_contact_information_id";

    private final ContactRepository contactRepository;
    private final Internationalization messagesBundle;

    @Autowired
    public ContactService(ContactRepository contactRepository, Internationalization internationalization) {
        this.contactRepository = contactRepository;
        this.messagesBundle = internationalization;
    }

    public ContactEntity create(ContactEntity contactEntity) throws InvalidInformationException {
        contactEntity = contactRepository.save(contactEntity);

        return contactEntity;
    }

    public ContactEntity update(Long id, ContactEntity contactEntity) throws InvalidInformationException {
        ContactEntity contactEntityToSave = this.findById(id);

        contactEntityToSave.setNomeCompleto(contactEntity.getNomeCompleto());
        contactEntityToSave.setTelefone(contactEntity.getTelefone());

        ContactEntity updatedContact = contactRepository.save(contactEntityToSave);

        return updatedContact;
    }

    public List<ContactEntity> list(Long page, Long count) throws InvalidPageRequestException {
        List<ContactEntity> contactEntityArrayList = contactRepository.findAll(PageRequest.of(page.intValue(), count.intValue())).toList();

        return contactEntityArrayList;
    }

    public ContactEntity findById(Long id) throws InvalidInformationException {
        ContactEntity contactEntity = contactRepository.getOne(id);

        if (contactEntity == null) {
            throw new InvalidInformationException(this.messagesBundle.getMessage(MESSAGE_INVALID_CONTACT_INFORMATION_ID));
        }

        return contactEntity;
    }

    public ContactEntity delete(Long id) throws InvalidInformationException {
        ContactEntity contactEntity = this.findById(id);

        if (contactEntity == null) {
            throw new InvalidInformationException(this.messagesBundle.getMessage(MESSAGE_INVALID_CONTACT_INFORMATION_ID));
        }

        contactRepository.delete(contactEntity);

        return contactEntity;
    }

    public Long count() {

        Long count = contactRepository.count();

        return count;
    }
}


