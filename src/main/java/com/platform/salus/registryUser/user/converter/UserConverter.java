package com.platform.salus.registryUser.user.converter;

import com.platform.salus.common.config.Internationalization;
import com.platform.salus.common.exceptions.InvalidInformationException;
import com.platform.salus.common.exceptions.InvalidPageRequestException;
import com.platform.salus.common.utils.ConverterUtils;
import com.platform.salus.common.utils.ValidationUtils;
import com.platform.salus.registryUser.user.converter.input.UserInput;
import com.platform.salus.registryUser.user.converter.input.UserUpdateInput;
import com.platform.salus.registryUser.user.converter.output.UserOutput;
import com.platform.salus.registryUser.user.model.UserEntity;
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

    public UserEntity inputToEntity(UserInput input) throws InvalidInformationException {
        checkUserCreate(input);
        return new UserEntity().setNomeCompleto(input.getNomeCompleto())
                .setDataNascimento(converterUtils.convertStringToLocalDate(input.getDataNascimento()))
                .setCpf(input.getCpf())
                .setTelefone(input.getTelefone())
                .setEmail(input.getEmail())
                .setSenha(input.getSenha())
                .setConfSenha(input.getConfSenha());
    }

    public UserEntity inputToEntity(UserUpdateInput input) throws InvalidInformationException {
        checkUserUpdate(input);
        return new UserEntity().setNomeCompleto(input.getNomeCompleto())
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

    public void checkUserCreate(UserInput input) throws InvalidInformationException {
        ValidationUtils.checkEmptyObject(input, this.messagesBundle.getMessage("invalid_user_information_object"));
        ValidationUtils.checkEmptyString(input.getNomeCompleto(), this.messagesBundle.getMessage("invalid_user_information_name"));
        ValidationUtils.checkDate(input.getDataNascimento(), this.messagesBundle.getMessage("invalid_user_information_date"));
        ValidationUtils.checkCpf(input.getCpf(), this.messagesBundle.getMessage("invalid_user_information_cpf"));
        ValidationUtils.checkFone(input.getTelefone(), this.messagesBundle.getMessage("invalid_user_information_fone"));
        ValidationUtils.checkEmail(input.getEmail(), this.messagesBundle.getMessage("invalid_user_information_email"));
        ValidationUtils.checkpass(input.getSenha(), input.getConfSenha(), this.messagesBundle.getMessage("invalid_user_information_pass"));
    }

    public void checkUserUpdate(UserUpdateInput input) throws InvalidInformationException {
        ValidationUtils.checkEmptyObject(input, this.messagesBundle.getMessage("invalid_user_information_object"));
        ValidationUtils.checkEmptyString(input.getNomeCompleto(), this.messagesBundle.getMessage("invalid_user_information_name"));
        ValidationUtils.checkFone(input.getTelefone(), this.messagesBundle.getMessage("invalid_user_information_fone"));
        ValidationUtils.checkEmail(input.getEmail(), this.messagesBundle.getMessage("invalid_user_information_email"));
        ValidationUtils.checkpass(input.getSenha(), input.getConfSenha(), this.messagesBundle.getMessage("invalid_user_information_pass"));
    }

    public void checkPageInfo(Long page, Long count) throws InvalidPageRequestException {
        ValidationUtils.checkValidPage(page, this.messagesBundle.getMessage("invalid_user_information_page"));
        ValidationUtils.checkValidCount(count, this.messagesBundle.getMessage("invalid_user_information_page_size"));
    }
}
