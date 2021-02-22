package com.platform.salus.registryUser.medicament.service;

import com.platform.salus.common.config.Internationalization;
import com.platform.salus.common.exceptions.InvalidInformationException;
import com.platform.salus.common.exceptions.InvalidPageRequestException;
import com.platform.salus.registryUser.medicament.model.MedicamentEntity;
import com.platform.salus.registryUser.medicament.repository.MedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentService {

    private static final String MESSAGE_INVALID_MEDICAMENT_INFORMATION_ID = "invalid_medicament_information_id";

    private final MedicamentRepository medicamentRepository;
    private final Internationalization messagesBundle;

    @Autowired
    public MedicamentService(MedicamentRepository medicamentRepository, Internationalization internationalization) {
        this.medicamentRepository = medicamentRepository;
        this.messagesBundle = internationalization;
    }

    public MedicamentEntity create(MedicamentEntity medicamentEntity) throws InvalidInformationException {
        medicamentEntity = medicamentRepository.save(medicamentEntity);

        return medicamentEntity;
    }

    public MedicamentEntity update(Long id, MedicamentEntity medicamentEntity) throws InvalidInformationException {
        MedicamentEntity medicamentEntityToSave = this.findById(id);

        medicamentEntityToSave.setNomeMedicamento(medicamentEntity.getNomeMedicamento());
        medicamentEntityToSave.setInicioMed(medicamentEntity.getInicioMed());
        medicamentEntityToSave.setFimMed(medicamentEntity.getFimMed());
        medicamentEntityToSave.setUsoContinuo(medicamentEntity.isUsoContinuo());

        MedicamentEntity updatedmedicament = medicamentRepository.save(medicamentEntityToSave);

        return updatedmedicament;
    }

    public List<MedicamentEntity> list(Long page, Long count) throws InvalidPageRequestException {
        List<MedicamentEntity> medicamentEntityArrayList = medicamentRepository.findAll(PageRequest.of(page.intValue(), count.intValue())).toList();

        return medicamentEntityArrayList;
    }

    public MedicamentEntity findById(Long id) throws InvalidInformationException {
        MedicamentEntity medicamentEntity = medicamentRepository.getOne(id);

        if (medicamentEntity == null) {
            throw new InvalidInformationException(this.messagesBundle.getMessage(MESSAGE_INVALID_MEDICAMENT_INFORMATION_ID));
        }

        return medicamentEntity;
    }

    public MedicamentEntity delete(Long id) throws InvalidInformationException {
        MedicamentEntity medicamentEntity = this.findById(id);

        if (medicamentEntity == null) {
            throw new InvalidInformationException(this.messagesBundle.getMessage(MESSAGE_INVALID_MEDICAMENT_INFORMATION_ID));
        }

        medicamentRepository.delete(medicamentEntity);

        return medicamentEntity;
    }

    public Long count() {

        Long count = medicamentRepository.count();

        return count;
    }
}


