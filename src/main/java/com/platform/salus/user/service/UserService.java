package com.platform.salus.user.service;

import com.platform.salus.common.config.Internationalization;
import com.platform.salus.common.exceptions.InvalidPageRequestException;
import com.platform.salus.common.exceptions.SalusException;
import com.platform.salus.user.model.UserEntity;
import com.platform.salus.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final String MESSAGE_INVALID_USER_INFORMATION_ID = "invalid_user_information_id";
    private static final String MESSAGE_INVALID_HOLDING_INFORMATION_OBJECT = "invalid_holding_information_object";
    private static final String MESSAGE_INVALID_INFORMATION_EXTERNAL_ID = "invalid_information_externalId";

    private final UserRepository userRepository;
    private final Internationalization messagesBundle;

    @Autowired
    public UserService(UserRepository userRepository, Internationalization internationalization) {
        this.userRepository = userRepository;
        this.messagesBundle = internationalization;
    }

    public UserEntity create(UserEntity userEntity) throws SalusException {
        userEntity = userRepository.save(userEntity);

        return userEntity;
    }

    public UserEntity update(Long id, UserEntity userEntity) throws SalusException {
        UserEntity userEntityToSave = this.findById(id);

        userEntityToSave.setNomeCompleto(userEntity.getNomeCompleto());
        userEntityToSave.setDataNascimento(userEntity.getDataNascimento());
        userEntityToSave.setCpf(userEntity.getCpf());
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

    public UserEntity findById(Long id) throws SalusException {
        UserEntity userEntity = userRepository.getOne(id);

        if (userEntity == null) {
            throw new SalusException(this.messagesBundle.getMessage(MESSAGE_INVALID_USER_INFORMATION_ID));
        }

        return userEntity;
    }

    public UserEntity delete(Long id) throws SalusException {
        UserEntity userEntity = this.findById(id);

        if (userEntity == null) {
            throw new SalusException(this.messagesBundle.getMessage(MESSAGE_INVALID_USER_INFORMATION_ID));
        }

        userRepository.delete(userEntity);

        return userEntity;
    }

    public Long count() {

        Long count = userRepository.count();

        return count;
    }
}


