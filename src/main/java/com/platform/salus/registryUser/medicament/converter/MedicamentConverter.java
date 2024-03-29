package com.platform.salus.registryUser.medicament.converter;

import com.platform.salus.common.config.Internationalization;
import com.platform.salus.common.exceptions.InvalidInformationException;
import com.platform.salus.common.exceptions.InvalidPageRequestException;
import com.platform.salus.common.utils.ConverterUtils;
import com.platform.salus.common.utils.ValidationUtils;
import com.platform.salus.registryUser.medicament.converter.input.MedicamentInput;
import com.platform.salus.registryUser.medicament.converter.output.MedicamentOutput;
import com.platform.salus.registryUser.medicament.model.MedicamentEntity;
import com.platform.salus.registryUser.user.converter.UserConverter;
import com.platform.salus.registryUser.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentConverter {

    private final Internationalization messagesBundle;
    private final ConverterUtils converterUtils;
    private final UserConverter userConverter;

    @Autowired
    public MedicamentConverter(Internationalization internationalization, ConverterUtils converterUtils, UserConverter userConverter) {
        this.messagesBundle = internationalization;
        this.converterUtils = converterUtils;
        this.userConverter = userConverter;
    }

    public MedicamentEntity inputToEntity(MedicamentInput input) throws InvalidInformationException {
        checkMedicamentCreate(input);
        UserEntity userEntity = userConverter.inputToEntity(input.getUser());
        userEntity.setId(input.getUser().getId());
        return new MedicamentEntity().setNomeMedicamento(input.getNomeMedicamento())
                .setInicioMed(converterUtils.convertStringToLocalDate(input.getInicioMed()))
                .setFimMed(converterUtils.convertStringToLocalDate(input.getFimMed()))
                .setUsoContinuo(Boolean.valueOf(input.getUsoContinuo()))
                .setUser(userEntity);
    }

    public MedicamentEntity inputToUpdateEntity(MedicamentInput input) throws InvalidInformationException {
        checkMedicamentCreate(input);
        return new MedicamentEntity().setNomeMedicamento(input.getNomeMedicamento())
                .setInicioMed(converterUtils.convertStringToLocalDate(input.getInicioMed()))
                .setFimMed(converterUtils.convertStringToLocalDate(input.getFimMed()))
                .setUsoContinuo(Boolean.valueOf(input.getUsoContinuo()));
    }

    public MedicamentOutput entityToOutput(MedicamentEntity medicamentEntity) {
        MedicamentOutput medicamentOutput = new MedicamentOutput();
        medicamentOutput.setId(medicamentEntity.getId().toString())
                .setNomeMedicamento(medicamentEntity.getNomeMedicamento())
                .setInicioMed(converterUtils.convertDateToString(medicamentEntity.getInicioMed()))
                .setFimMed(converterUtils.convertDateToString(medicamentEntity.getFimMed()))
                .setUsoContinuo(String.valueOf(medicamentEntity.isUsoContinuo()))
                .setUser(medicamentEntity.getUser());

        return medicamentOutput;
    }

    public void checkMedicamentCreate(MedicamentInput input) throws InvalidInformationException {
        ValidationUtils.checkEmptyObject(input, this.messagesBundle.getMessage("invalid_medicament_information_object"));
        ValidationUtils.checkEmptyString(input.getNomeMedicamento(), this.messagesBundle.getMessage("invalid_medicament_information_name"));
        ValidationUtils.checkDate(input.getInicioMed(), this.messagesBundle.getMessage("invalid_medicament_information_date"));
        ValidationUtils.checkDate(input.getFimMed(), this.messagesBundle.getMessage("invalid_medicament_information_date"));
        ValidationUtils.checkValidBoolean(input.getUsoContinuo(), this.messagesBundle.getMessage("invalid_medicament_information_boolean"));
    }

    public void checkPageInfo(Long page, Long count) throws InvalidPageRequestException {
        ValidationUtils.checkValidPage(page, this.messagesBundle.getMessage("invalid_medicament_information_page"));
        ValidationUtils.checkValidCount(count, this.messagesBundle.getMessage("invalid_medicament_information_page_size"));
    }
}
