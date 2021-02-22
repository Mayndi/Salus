package com.platform.salus.registryUser.contact.converter;

import com.platform.salus.common.config.Internationalization;
import com.platform.salus.common.exceptions.InvalidInformationException;
import com.platform.salus.common.exceptions.InvalidPageRequestException;
import com.platform.salus.common.utils.ConverterUtils;
import com.platform.salus.common.utils.ValidationUtils;
import com.platform.salus.registryUser.contact.converter.input.ContactInput;
import com.platform.salus.registryUser.contact.converter.output.ContactOutput;
import com.platform.salus.registryUser.contact.model.ContactEntity;
import com.platform.salus.registryUser.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactConverter {

    private final Internationalization messagesBundle;
    private final ConverterUtils converterUtils;

    @Autowired
    public ContactConverter(Internationalization internationalization, ConverterUtils converterUtils) {
        this.messagesBundle = internationalization;
        this.converterUtils = converterUtils;
    }

    public ContactEntity inputToEntity(ContactInput input) throws InvalidInformationException {
        checkContactCreate(input);
        return new ContactEntity().setNomeCompleto(input.getNomeCompleto())
                .setTelefone(input.getTelefone())
                .setUser(new UserEntity().setId(Long.valueOf(input.getUser())));
    }

    public ContactOutput entityToOutput(ContactEntity contactEntity) {
        ContactOutput contactOutput = new ContactOutput();
        contactOutput.setId(contactEntity.getId().toString())
                .setNomeCompleto(contactEntity.getNomeCompleto())
                .setTelefone(contactEntity.getTelefone())
                .setUser(contactEntity.getUser().getId().toString());

        return contactOutput;
    }

    public void checkContactCreate(ContactInput input) throws InvalidInformationException {
        ValidationUtils.checkEmptyObject(input, this.messagesBundle.getMessage("invalid_contact_information_object"));
        ValidationUtils.checkEmptyString(input.getNomeCompleto(), this.messagesBundle.getMessage("invalid_contact_information_nameContact"));
        ValidationUtils.checkFone(input.getTelefone(), this.messagesBundle.getMessage("invalid_contact_information_foneContact"));
    }

    public void checkPageInfo(Long page, Long count) throws InvalidPageRequestException {
        ValidationUtils.checkValidPage(page, this.messagesBundle.getMessage("invalid_contact_information_page"));
        ValidationUtils.checkValidCount(count, this.messagesBundle.getMessage("invalid_contact_information_page_size"));
    }
}
