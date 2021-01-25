package com.platform.salus.registry.address.converter;

import com.platform.salus.common.config.Internationalization;
import com.platform.salus.common.exceptions.InvalidInformationException;
import com.platform.salus.common.exceptions.InvalidPageRequestException;
import com.platform.salus.common.utils.ConverterUtils;
import com.platform.salus.common.utils.ValidationUtils;
import com.platform.salus.registry.address.converter.input.AddressInput;
import com.platform.salus.registry.address.converter.output.AddressOutput;
import com.platform.salus.registry.address.model.AddressEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressConverter {

    private final Internationalization messagesBundle;
    private final ConverterUtils converterUtils;

    @Autowired
    public AddressConverter(Internationalization internationalization, ConverterUtils converterUtils) {
        this.messagesBundle = internationalization;
        this.converterUtils = converterUtils;
    }

    public AddressEntity inputToEntity(AddressInput input) throws InvalidInformationException {
        checkAddressCreate(input);
        return new AddressEntity().setCep(input.getCep())
                .setPais(input.getPais())
                .setEstado(input.getEstado())
                .setCidade(input.getCidade())
                .setBairro(input.getBairro())
                .setRua(input.getRua())
                .setNumero(input.getNumero())
                .setComplemento(input.getComplemento())
                .setReferencia(input.getReferencia());
    }

    public AddressOutput entityToOutput(AddressEntity addressEntity) {
        AddressOutput addressOutput = new AddressOutput();
        addressOutput.setId(addressEntity.getId().toString())
                .setCep(addressEntity.getCep())
                .setPais(addressEntity.getPais())
                .setEstado(addressEntity.getEstado())
                .setCidade(addressEntity.getCidade())
                .setBairro(addressEntity.getBairro())
                .setRua(addressEntity.getRua())
                .setNumero(addressEntity.getNumero())
                .setComplemento(addressEntity.getComplemento())
                .setReferencia(addressEntity.getReferencia());

        return addressOutput;
    }

    public void checkAddressCreate(AddressInput input) throws InvalidInformationException {
        ValidationUtils.checkEmptyObject(input, this.messagesBundle.getMessage("invalid_address_information_object"));
        ValidationUtils.checkCep(input.getCep(), this.messagesBundle.getMessage("invalid_address_information_cep"));
        ValidationUtils.checkEmptyString(input.getPais(), this.messagesBundle.getMessage("invalid_address_information_country"));
        ValidationUtils.checkEmptyString(input.getEstado(), this.messagesBundle.getMessage("invalid_address_information_state"));
        ValidationUtils.checkEmptyString(input.getCidade(), this.messagesBundle.getMessage("invalid_address_information_city"));
        ValidationUtils.checkEmptyString(input.getBairro(), this.messagesBundle.getMessage("invalid_address_information_district"));
        ValidationUtils.checkEmptyString(input.getRua(), this.messagesBundle.getMessage("invalid_address_information_street"));
        ValidationUtils.checkEmptyString(input.getNumero(), this.messagesBundle.getMessage("invalid_address_information_number"));
    }

    public void checkPageInfo(Long page, Long count) throws InvalidPageRequestException {
        ValidationUtils.checkValidPage(page, this.messagesBundle.getMessage("invalid_address_information_page"));
        ValidationUtils.checkValidCount(count, this.messagesBundle.getMessage("invalid_address_information_page_size"));
    }
}
