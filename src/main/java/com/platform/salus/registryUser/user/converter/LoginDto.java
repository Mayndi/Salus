package com.platform.salus.registryUser.user.converter;

import com.platform.salus.registryUser.address.model.AddressEntity;
import com.platform.salus.registryUser.contact.model.ContactEntity;
import com.platform.salus.registryUser.medic.model.MedicEntity;
import com.platform.salus.registryUser.medicament.model.MedicamentEntity;
import com.platform.salus.registryUser.user.model.UserEntity;

public class LoginDto {

    UserEntity userEntity;
    AddressEntity addressEntity;
    ContactEntity contactEntity;
    MedicEntity medicEntity;
    MedicamentEntity medicamentEntity;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public LoginDto setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public LoginDto setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
        return this;
    }

    public ContactEntity getContactEntity() {
        return contactEntity;
    }

    public LoginDto setContactEntity(ContactEntity contactEntity) {
        this.contactEntity = contactEntity;
        return this;
    }

    public MedicEntity getMedicEntity() {
        return medicEntity;
    }

    public LoginDto setMedicEntity(MedicEntity medicEntity) {
        this.medicEntity = medicEntity;
        return this;
    }

    public MedicamentEntity getMedicamentEntity() {
        return medicamentEntity;
    }

    public LoginDto setMedicamentEntity(MedicamentEntity medicamentEntity) {
        this.medicamentEntity = medicamentEntity;
        return this;
    }
}
