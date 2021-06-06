package com.platform.salus.registryUser.address.converter;

import com.platform.salus.common.config.Internationalization;
import com.platform.salus.common.exceptions.InvalidInformationException;
import com.platform.salus.common.exceptions.InvalidPageRequestException;
import com.platform.salus.common.utils.ConverterUtils;
import com.platform.salus.common.utils.ValidationUtils;
import com.platform.salus.registryUser.address.converter.input.AddressInput;
import com.platform.salus.registryUser.address.converter.output.AddressOutput;
import com.platform.salus.registryUser.address.model.AddressEntity;
import com.platform.salus.registryUser.user.converter.UserConverter;
import com.platform.salus.registryUser.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressConverter {

    private final Internationalization messagesBundle;
    private final ConverterUtils converterUtils;
    private final UserConverter userConverter;

    @Autowired
    public AddressConverter(Internationalization internationalization, ConverterUtils converterUtils, UserConverter userConverter) {
        this.messagesBundle = internationalization;
        this.converterUtils = converterUtils;
        this.userConverter = userConverter;
    }

    public AddressEntity inputToEntity(AddressInput input) throws InvalidInformationException {
        checkAddressCreate(input);
        UserEntity userEntity = userConverter.inputToEntity(input.getUser());
        userEntity.setId(input.getUser().getId());
        return new AddressEntity().setCep(input.getCep())
                .setEstado(input.getEstado())
                .setCidade(input.getCidade())
                .setBairro(input.getBairro())
                .setRua(input.getRua())
                .setNumero(input.getNumero())
                .setComplemento(input.getComplemento())
                .setReferencia(input.getReferencia())
                .setUser(userEntity);
    }

    public AddressEntity inputToUpdateEntity(AddressInput input) throws InvalidInformationException {
        checkAddressCreate(input);
        return new AddressEntity().setCep(input.getCep())
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
                .setEstado(addressEntity.getEstado())
                .setCidade(addressEntity.getCidade())
                .setBairro(addressEntity.getBairro())
                .setRua(addressEntity.getRua())
                .setNumero(addressEntity.getNumero())
                .setComplemento(addressEntity.getComplemento())
                .setReferencia(addressEntity.getReferencia())
                .setUser(addressEntity.getUser());

        return addressOutput;
    }

    public void checkAddressCreate(AddressInput input) throws InvalidInformationException {
        ValidationUtils.checkEmptyObject(input, this.messagesBundle.getMessage("invalid_address_information_object"));
        ValidationUtils.checkCep(input.getCep(), this.messagesBundle.getMessage("invalid_address_information_cep"));
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
