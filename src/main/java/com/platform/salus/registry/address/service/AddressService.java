package com.platform.salus.registry.address.service;

import com.platform.salus.common.config.Internationalization;
import com.platform.salus.common.exceptions.InvalidInformationException;
import com.platform.salus.common.exceptions.InvalidPageRequestException;
import com.platform.salus.registry.address.model.AddressEntity;
import com.platform.salus.registry.address.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private static final String MESSAGE_INVALID_ADDRESS_INFORMATION_ID = "invalid_address_information_id";

    private final AddressRepository addressRepository;
    private final Internationalization messagesBundle;

    @Autowired
    public AddressService(AddressRepository addressRepository, Internationalization internationalization) {
        this.addressRepository = addressRepository;
        this.messagesBundle = internationalization;
    }

    public AddressEntity create(AddressEntity addressEntity) throws InvalidInformationException {
        addressEntity = addressRepository.save(addressEntity);

        return addressEntity;
    }

    public AddressEntity update(Long id, AddressEntity addressEntity) throws InvalidInformationException {
        AddressEntity addressEntityToSave = this.findById(id);

        addressEntityToSave.setCep(addressEntity.getCep());
        addressEntityToSave.setPais(addressEntity.getPais());
        addressEntityToSave.setEstado(addressEntity.getEstado());
        addressEntityToSave.setCidade(addressEntity.getCidade());
        addressEntityToSave.setBairro(addressEntity.getBairro());
        addressEntityToSave.setRua(addressEntity.getRua());
        addressEntityToSave.setNumero(addressEntity.getNumero());
        addressEntityToSave.setComplemento(addressEntity.getComplemento());
        addressEntityToSave.setReferencia(addressEntity.getReferencia());

        AddressEntity updatedaddress = addressRepository.save(addressEntityToSave);

        return updatedaddress;
    }

    public List<AddressEntity> list(Long page, Long count) throws InvalidPageRequestException {
        List<AddressEntity> addressEntityArrayList = addressRepository.findAll(PageRequest.of(page.intValue(), count.intValue())).toList();

        return addressEntityArrayList;
    }

    public AddressEntity findById(Long id) throws InvalidInformationException {
        AddressEntity addressEntity = addressRepository.getOne(id);

        if (addressEntity == null) {
            throw new InvalidInformationException(this.messagesBundle.getMessage(MESSAGE_INVALID_ADDRESS_INFORMATION_ID));
        }

        return addressEntity;
    }

    public AddressEntity delete(Long id) throws InvalidInformationException {
        AddressEntity addressEntity = this.findById(id);

        if (addressEntity == null) {
            throw new InvalidInformationException(this.messagesBundle.getMessage(MESSAGE_INVALID_ADDRESS_INFORMATION_ID));
        }

        addressRepository.delete(addressEntity);

        return addressEntity;
    }

    public Long count() {

        Long count = addressRepository.count();

        return count;
    }
}


