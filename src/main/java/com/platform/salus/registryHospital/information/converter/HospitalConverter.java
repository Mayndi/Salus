package com.platform.salus.registryHospital.information.converter;

import com.platform.salus.common.config.Internationalization;
import com.platform.salus.common.exceptions.InvalidInformationException;
import com.platform.salus.common.exceptions.InvalidPageRequestException;
import com.platform.salus.common.utils.ConverterUtils;
import com.platform.salus.common.utils.ValidationUtils;
import com.platform.salus.registryHospital.information.converter.input.HospitalInput;
import com.platform.salus.registryHospital.information.converter.output.HospitalOutput;
import com.platform.salus.registryHospital.information.model.HospitalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalConverter {

    private final Internationalization messagesBundle;
    private final ConverterUtils converterUtils;

    @Autowired
    public HospitalConverter(Internationalization internationalization, ConverterUtils converterUtils) {
        this.messagesBundle = internationalization;
        this.converterUtils = converterUtils;
    }

    public HospitalEntity inputToEntity(HospitalInput input) throws InvalidInformationException {
        checkHospitalCreate(input);
        return new HospitalEntity().setNome(input.getNome())
                .setTelefone(input.getTelefone())
                .setTipo(input.getTipo())
                .setCnpj(input.getCnpj());
    }

    public HospitalOutput entityToOutput(HospitalEntity hospitalEntity) {
        HospitalOutput hospitalOutput = new HospitalOutput();
        hospitalOutput.setId(hospitalEntity.getId().toString())
                .setNome(hospitalEntity.getNome())
                .setTelefone(hospitalEntity.getTelefone())
                .setTipo(hospitalEntity.getTipo())
                .setCnpj(hospitalEntity.getCnpj());

        return hospitalOutput;
    }

    public void checkHospitalCreate(HospitalInput input) throws InvalidInformationException {
        ValidationUtils.checkEmptyObject(input, this.messagesBundle.getMessage("invalid_hospital_information_object"));
        ValidationUtils.checkEmptyString(input.getNome(), this.messagesBundle.getMessage("invalid_hospital_information_nameHospital"));
        ValidationUtils.checkEmptyString(input.getTipo(), this.messagesBundle.getMessage("invalid_hospital_information_type"));
        ValidationUtils.checkFone(input.getTelefone(), this.messagesBundle.getMessage("invalid_hospital_information_foneHospital"));
        ValidationUtils.checkCnpj(input.getCnpj(), this.messagesBundle.getMessage("invalid_hospital_information_cnpj"));
    }

    public void checkPageInfo(Long page, Long count) throws InvalidPageRequestException {
        ValidationUtils.checkValidPage(page, this.messagesBundle.getMessage("invalid_hospital_information_page"));
        ValidationUtils.checkValidCount(count, this.messagesBundle.getMessage("invalid_hospital_information_page_size"));
    }
}
