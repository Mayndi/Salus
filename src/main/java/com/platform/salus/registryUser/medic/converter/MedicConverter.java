package com.platform.salus.registryUser.medic.converter;

import com.platform.salus.common.config.Internationalization;
import com.platform.salus.common.exceptions.InvalidInformationException;
import com.platform.salus.common.exceptions.InvalidPageRequestException;
import com.platform.salus.common.utils.ConverterUtils;
import com.platform.salus.common.utils.ValidationUtils;
import com.platform.salus.registryUser.medic.converter.input.MedicInput;
import com.platform.salus.registryUser.medic.converter.input.MedicUpdateInput;
import com.platform.salus.registryUser.medic.converter.output.MedicOutput;
import com.platform.salus.registryUser.medic.model.MedicEntity;
import com.platform.salus.registryUser.user.converter.UserConverter;
import com.platform.salus.registryUser.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicConverter {

    private final Internationalization messagesBundle;
    private final ConverterUtils converterUtils;
    private final UserConverter userConverter;

    @Autowired
    public MedicConverter(Internationalization internationalization, ConverterUtils converterUtils, UserConverter userConverter) {
        this.messagesBundle = internationalization;
        this.converterUtils = converterUtils;
        this.userConverter = userConverter;
    }

    public MedicEntity inputToEntity(MedicInput input) throws InvalidInformationException {
        checkMedicCreate(input);
        UserEntity userEntity = userConverter.inputToEntity(input.getUser());
        userEntity.setId(input.getUser().getId());
        return new MedicEntity().setnSus(input.getnSus())
                .setnConvenio(input.getnConvenio())
                .setTelefoneConvenio(input.getTelefoneConvenio())
                .setHistorico(input.getHistorico())
                .setTipoSanguineo(input.getTipoSanguineo())
                .setDeficiencia(input.getDeficiencia())
                .setAlergias(input.getAlergias())
                .setObs(input.getObs())
                .setUser(userEntity);
    }

    public MedicEntity inputToUpdateEntity(MedicUpdateInput input) throws InvalidInformationException {
        checkMedicCreate(input);
        return new MedicEntity().setnSus(input.getnSus())
                .setnConvenio(input.getnConvenio())
                .setTelefoneConvenio(input.getTelefoneConvenio())
                .setHistorico(input.getHistorico())
                .setDeficiencia(input.getDeficiencia())
                .setAlergias(input.getAlergias())
                .setObs(input.getObs());
    }


    public MedicOutput entityToOutput(MedicEntity medicEntity) {
        MedicOutput medicOutput = new MedicOutput();
        medicOutput.setId(medicEntity.getId().toString())
                .setnSus(medicEntity.getnSus())
                .setnConvenio(medicEntity.getnConvenio())
                .setTelefoneConvenio(medicEntity.getTelefoneConvenio())
                .setHistorico(medicEntity.getHistorico())
                .setTipoSanguineo(medicEntity.getTipoSanguineo())
                .setDeficiencia(medicEntity.getDeficiencia())
                .setAlergias(medicEntity.getAlergias())
                .setObs(medicEntity.getObs())
                .setUser(medicEntity.getUser());
        return medicOutput;
    }

    public void checkMedicCreate(MedicInput input) throws InvalidInformationException {
        ValidationUtils.checkEmptyObject(input, this.messagesBundle.getMessage("invalid_medic_information_object"));
        ValidationUtils.checkSus(input.getnSus(), this.messagesBundle.getMessage("invalid_medic_information_sus"));
        ValidationUtils.checkEmptyString(input.getHistorico(), this.messagesBundle.getMessage("invalid_medic_information_historico"));
        ValidationUtils.checkEmptyString(input.getTipoSanguineo(), this.messagesBundle.getMessage("invalid_medic_information_tipoSanguineo"));
    }

    public void checkMedicCreate(MedicUpdateInput input) throws InvalidInformationException {
        ValidationUtils.checkEmptyObject(input, this.messagesBundle.getMessage("invalid_medic_information_object"));
        ValidationUtils.checkSus(input.getnSus(), this.messagesBundle.getMessage("invalid_medic_information_sus"));
        ValidationUtils.checkEmptyString(input.getHistorico(), this.messagesBundle.getMessage("invalid_medic_information_historico"));
    }

    public void checkPageInfo(Long page, Long count) throws InvalidPageRequestException {
        ValidationUtils.checkValidPage(page, this.messagesBundle.getMessage("invalid_medic_information_page"));
        ValidationUtils.checkValidCount(count, this.messagesBundle.getMessage("invalid_medic_information_page_size"));
    }
}
