package com.platform.salus.user.converter;

import com.platform.salus.common.config.Internationalization;
import com.platform.salus.common.exceptions.SalusException;
import com.platform.salus.common.utils.ConverterUtils;
import com.platform.salus.user.converter.input.UserInput;
import com.platform.salus.user.converter.output.UserOutput;
import com.platform.salus.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {

    private final Internationalization messagesBundle;
    private final ConverterUtils converterUtils;

    @Autowired
    public UserConverter(Internationalization internationalization, ConverterUtils converterUtils) {
        this.messagesBundle = internationalization;
        this.converterUtils = converterUtils;
    }

    public UserEntity inputToEntity(UserInput input) throws SalusException {
        return new UserEntity().setNomeCompleto(input.getNomeCompleto())
                .setDataNascimento(converterUtils.convertStringToLocalDate(input.getDataNascimento()))
                .setCpf(input.getCpf())
                .setTelefone(input.getTelefone())
                .setEmail(input.getEmail())
                .setSenha(input.getSenha())
                .setConfSenha(input.getConfSenha());
    }

    public UserOutput entityToOutput(UserEntity userEntity) {
        UserOutput userOutput = new UserOutput();
        userOutput.setId(userEntity.getId().toString())
                .setNomeCompleto(userEntity.getNomeCompleto())
                .setDataNascimento(converterUtils.convertDateToString(userEntity.getDataNascimento()))
                .setCpf(userEntity.getCpf())
                .setTelefone(userEntity.getTelefone())
                .setEmail(userEntity.getEmail())
                .setSenha(userEntity.getSenha());

        return userOutput;
    }
}
