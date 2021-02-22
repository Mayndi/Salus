package com.platform.salus.registryUser.contact.controller;

import com.platform.salus.common.exceptions.InvalidInformationException;
import com.platform.salus.common.exceptions.InvalidPageRequestException;
import com.platform.salus.registryUser.contact.converter.ContactConverter;
import com.platform.salus.registryUser.contact.converter.input.ContactInput;
import com.platform.salus.registryUser.contact.converter.output.ContactCountOutput;
import com.platform.salus.registryUser.contact.converter.output.ContactOutput;
import com.platform.salus.registryUser.contact.model.ContactEntity;
import com.platform.salus.registryUser.contact.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user/contact")
public class ContactController extends ContactBaseController {

    private final ContactService contactService;
    private final ContactConverter contactConverter;

    public ContactController(ContactService contactService, ContactConverter contactConverter) {
        this.contactService = contactService;
        this.contactConverter = contactConverter;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ContactOutput> create(@RequestBody ContactInput contact) {

        try {
            ContactEntity contactEntity = contactService.create(this.contactConverter.inputToEntity(contact));

            return ok(this.contactConverter.entityToOutput(contactEntity));
        } catch (InvalidInformationException ex) {
            return error((ContactOutput) new ContactOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ContactOutput> update(@PathVariable Long id, @RequestBody ContactInput contact) {

        try {
            ContactEntity contactEntity = contactService.update(id, this.contactConverter.inputToEntity(contact));

            return ok(this.contactConverter.entityToOutput(contactEntity));
        } catch (InvalidInformationException ex) {
            return error((ContactOutput) new ContactOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<ContactOutput> findById(@PathVariable Long id) {

        try {
            ContactEntity contactEntity = contactService.findById(id);

            return ok(this.contactConverter.entityToOutput(contactEntity));
        } catch (InvalidInformationException ex) {
            return error((ContactOutput) new ContactOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @GetMapping(value = "/list/{page}/{count}")
    public ResponseEntity<List<ContactOutput>> list(@PathVariable Long page, @PathVariable Long count) {

        try {
            contactConverter.checkPageInfo(page, count);
            List<ContactEntity> contacts = contactService.list(page, count);

            return ok(contacts.stream()
                    .map(this.contactConverter::entityToOutput)
                    .collect(Collectors.toList()));
        } catch (InvalidPageRequestException ex) {
            return error(Collections.singletonList((ContactOutput) new ContactOutput().setErrorMessage(ex.getMessage())));
        }
    }

    @GetMapping(value = "/count")
    public ResponseEntity<ContactCountOutput> count() {

        try {
            Long count = contactService.count();

            return ok(new ContactCountOutput().setCount(count));
        } catch (Exception ex){
            return error((ContactCountOutput) new ContactCountOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ContactOutput> delete(@PathVariable Long id) {

        try {
            ContactEntity contactEntity = contactService.delete(id);

            return ok((ContactOutput) new ContactOutput().setSuccessMessage(""));
        } catch (InvalidInformationException ex) {
            return error((ContactOutput) new ContactOutput().setErrorMessage(ex.getMessage()));
        }
    }
}
