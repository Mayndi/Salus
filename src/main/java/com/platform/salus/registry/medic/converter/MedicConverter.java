package com.platform.salus.registry.medic.converter;

import com.platform.salus.common.config.Internationalization;
import com.platform.salus.common.exceptions.InvalidInformationException;
import com.platform.salus.common.exceptions.InvalidPageRequestException;
import com.platform.salus.common.utils.ConverterUtils;
import com.platform.salus.common.utils.ValidationUtils;
import com.platform.salus.registry.medic.converter.input.MedicInput;
import com.platform.salus.registry.medic.converter.output.MedicOutput;
import com.platform.salus.registry.medic.model.MedicEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicConverter {

    private final Internationalization messagesBundle;
    private final ConverterUtils converterUtils;

    @Autowired
    public MedicConverter(Internationalization internationalization, ConverterUtils converterUtils) {
        this.messagesBundle = internationalization;
        this.converterUtils = converterUtils;
    }

    public MedicEntity inputToEntity(MedicInput input) throws InvalidInformationException {
        checkMedicCreate(input);
        return new MedicEntity().setnSus(input.getnSus())
                .setnConvenio(input.getnConvenio())
                .setTelefoneConvenio(input.getTelefoneConvenio())
                .setHistorico(input.getHistorico())
                .setTipoSanguineo(input.getTipoSanguineo())
                .setSexo(input.getSexo())
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
                .setSexo(medicEntity.getSexo())
                .setDeficiencia(medicEntity.getDeficiencia())
                .setAlergias(medicEntity.getAlergias())
                .setObs(medicEntity.getObs());

        return medicOutput;
    }

    public void checkMedicCreate(MedicInput input) throws InvalidInformationException {
        ValidationUtils.checkEmptyObject(input, this.messagesBundle.getMessage("invalid_medic_information_object"));
        ValidationUtils.checkSus(input.getnSus(), this.messagesBundle.getMessage("invalid_medic_information_sus"));
        ValidationUtils.checkEmptyString(input.getHistorico(), this.messagesBundle.getMessage("invalid_medic_information_historico"));
        ValidationUtils.checkEmptyString(input.getTipoSanguineo(), this.messagesBundle.getMessage("invalid_medic_information_tipoSanguineo"));
        ValidationUtils.checkEmptyString(input.getSexo(), this.messagesBundle.getMessage("invalid_medic_information_sexo"));
    }

    public void checkPageInfo(Long page, Long count) throws InvalidPageRequestException {
        ValidationUtils.checkValidPage(page, this.messagesBundle.getMessage("invalid_medic_information_page"));
        ValidationUtils.checkValidCount(count, this.messagesBundle.getMessage("invalid_medic_information_page_size"));
    }
}
