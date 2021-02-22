package com.platform.salus.registryHospital.information.service;

import com.platform.salus.common.config.Internationalization;
import com.platform.salus.common.exceptions.InvalidInformationException;
import com.platform.salus.common.exceptions.InvalidPageRequestException;
import com.platform.salus.registryHospital.information.model.HospitalEntity;
import com.platform.salus.registryHospital.information.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {

    private static final String MESSAGE_INVALID_HOSPITAL_INFORMATION_ID = "invalid_hospital_information_id";

    private final HospitalRepository hospitalRepository;
    private final Internationalization messagesBundle;

    @Autowired
    public HospitalService(HospitalRepository hospitalRepository, Internationalization internationalization) {
        this.hospitalRepository = hospitalRepository;
        this.messagesBundle = internationalization;
    }

    public HospitalEntity create(HospitalEntity hospitalEntity) throws InvalidInformationException {
        hospitalEntity = hospitalRepository.save(hospitalEntity);

        return hospitalEntity;
    }

    public HospitalEntity update(Long id, HospitalEntity hospitalEntity) throws InvalidInformationException {
        HospitalEntity hospitalEntityToSave = this.findById(id);

        hospitalEntityToSave.setNome(hospitalEntity.getNome());
        hospitalEntityToSave.setTelefone(hospitalEntity.getTelefone());
        hospitalEntityToSave.setCnpj(hospitalEntity.getCnpj());
        hospitalEntityToSave.setTipo(hospitalEntity.getTipo());

        HospitalEntity updatedhospital = hospitalRepository.save(hospitalEntityToSave);

        return updatedhospital;
    }

    public List<HospitalEntity> list(Long page, Long count) throws InvalidPageRequestException {
        List<HospitalEntity> hospitalEntityArrayList = hospitalRepository.findAll(PageRequest.of(page.intValue(), count.intValue())).toList();

        return hospitalEntityArrayList;
    }

    public HospitalEntity findById(Long id) throws InvalidInformationException {
        HospitalEntity hospitalEntity = hospitalRepository.getOne(id);

        if (hospitalEntity == null) {
            throw new InvalidInformationException(this.messagesBundle.getMessage(MESSAGE_INVALID_HOSPITAL_INFORMATION_ID));
        }

        return hospitalEntity;
    }

    public HospitalEntity delete(Long id) throws InvalidInformationException {
        HospitalEntity hospitalEntity = this.findById(id);

        if (hospitalEntity == null) {
            throw new InvalidInformationException(this.messagesBundle.getMessage(MESSAGE_INVALID_HOSPITAL_INFORMATION_ID));
        }

        hospitalRepository.delete(hospitalEntity);

        return hospitalEntity;
    }

    public Long count() {

        Long count = hospitalRepository.count();

        return count;
    }
}


