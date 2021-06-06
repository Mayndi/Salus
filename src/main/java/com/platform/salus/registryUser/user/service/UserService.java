package com.platform.salus.registryUser.user.service;

import com.platform.salus.common.config.Internationalization;
import com.platform.salus.common.exceptions.InvalidInformationException;
import com.platform.salus.common.exceptions.InvalidPageRequestException;
import com.platform.salus.registryUser.address.repository.AddressRepository;
import com.platform.salus.registryUser.contact.repository.ContactRepository;
import com.platform.salus.registryUser.medic.repository.MedicRepository;
import com.platform.salus.registryUser.medicament.repository.MedicamentRepository;
import com.platform.salus.registryUser.user.converter.LoginDto;
import com.platform.salus.registryUser.user.converter.UserConverter;
import com.platform.salus.registryUser.user.converter.input.Login;
import com.platform.salus.registryUser.user.model.UserEntity;
import com.platform.salus.registryUser.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final String MESSAGE_INVALID_USER_INFORMATION_ID = "invalid_user_information_id";

    private final UserRepository userRepository;
    private final Internationalization messagesBundle;
    private final UserConverter userConverter;
    private final AddressRepository addressRepository;
    private final MedicRepository medicRepository;
    private final MedicamentRepository medicamentRepository;
    private final ContactRepository contactRepository;

    @Autowired
    public UserService(UserRepository userRepository, Internationalization internationalization, UserConverter userConverter, AddressRepository addressRepository, MedicRepository medicRepository, MedicamentRepository medicamentRepository, ContactRepository contactRepository) {
        this.userRepository = userRepository;
        this.messagesBundle = internationalization;
        this.userConverter = userConverter;
        this.addressRepository = addressRepository;
        this.medicRepository = medicRepository;
        this.medicamentRepository = medicamentRepository;
        this.contactRepository = contactRepository;
    }

    public UserEntity create(UserEntity userEntity) throws InvalidInformationException {
        userEntity = userRepository.save(userEntity);

        return userEntity;
    }

    public UserEntity update(Long id, UserEntity userEntity) throws InvalidInformationException {
        UserEntity userEntityToSave = this.findById(id);

        userEntityToSave.setNomeCompleto(userEntity.getNomeCompleto());
        userEntityToSave.setTelefone(userEntity.getTelefone());
        userEntityToSave.setEmail(userEntity.getEmail());
        userEntityToSave.setSenha(userEntity.getSenha());
        userEntityToSave.setConfSenha(userEntity.getConfSenha());

        UserEntity updatedUser = userRepository.save(userEntityToSave);

        return updatedUser;
    }

    public List<UserEntity> list(Long page, Long count) throws InvalidPageRequestException {
        List<UserEntity> userEntityArrayList = userRepository.findAll(PageRequest.of(page.intValue(), count.intValue())).toList();

        return userEntityArrayList;
    }

    public UserEntity findById(Long id) throws InvalidInformationException {
        UserEntity userEntity = userRepository.getOne(id);

        if (userEntity == null) {
            throw new InvalidInformationException(this.messagesBundle.getMessage(MESSAGE_INVALID_USER_INFORMATION_ID));
        }

        return userEntity;
    }

    public UserEntity delete(Long id) throws InvalidInformationException {
        UserEntity userEntity = this.findById(id);

        if (userEntity == null) {
            throw new InvalidInformationException(this.messagesBundle.getMessage(MESSAGE_INVALID_USER_INFORMATION_ID));
        }

        userRepository.delete(userEntity);

        return userEntity;
    }

    public Long count() {

        Long count = userRepository.count();

        return count;
    }

    public LoginDto login(Login login) {
        Optional<UserEntity> userEntity = userRepository.findByEmailAndSenha(login.getEmail(), login.getSenha());
        if(userEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        UserEntity user = userEntity.get();

        return new LoginDto().setUserEntity(user)
                .setAddressEntity(addressRepository.findByUser(user))
                .setContactEntity(contactRepository.findByUser(user))
                .setMedicEntity(medicRepository.findByUser(user))
                .setMedicamentEntity(medicamentRepository.findByUser(user));
    }
}


