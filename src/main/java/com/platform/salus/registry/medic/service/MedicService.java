package com.platform.salus.registry.medic.service;

import com.platform.salus.common.config.Internationalization;
import com.platform.salus.common.exceptions.InvalidInformationException;
import com.platform.salus.common.exceptions.InvalidPageRequestException;
import com.platform.salus.registry.medic.model.MedicEntity;
import com.platform.salus.registry.medic.repository.MedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicService {

    private static final String MESSAGE_INVALID_MEDIC_INFORMATION_ID = "invalid_medic_information_id";

    private final MedicRepository medicRepository;
    private final Internationalization messagesBundle;

    @Autowired
    public MedicService(MedicRepository medicRepository, Internationalization internationalization) {
        this.medicRepository = medicRepository;
        this.messagesBundle = internationalization;
    }

    public MedicEntity create(MedicEntity medicEntity) throws InvalidInformationException {
        medicEntity = medicRepository.save(medicEntity);

        return medicEntity;
    }

    public MedicEntity update(Long id, MedicEntity medicEntity) throws InvalidInformationException {
        MedicEntity medicEntityToSave = this.findById(id);

        medicEntityToSave.setnSus(medicEntity.getnSus());
        medicEntityToSave.setnConvenio(medicEntity.getnConvenio());
        medicEntityToSave.setTelefoneConvenio(medicEntity.getTelefoneConvenio());
        medicEntityToSave.setHistorico(medicEntity.getHistorico());
        medicEntityToSave.setTipoSanguineo(medicEntity.getTipoSanguineo());
        medicEntityToSave.setSexo(medicEntity.getSexo());
        medicEntityToSave.setDeficiencia(medicEntity.getDeficiencia());
        medicEntityToSave.setAlergias(medicEntity.getAlergias());
        medicEntityToSave.setObs(medicEntity.getObs());

        MedicEntity updatedmedic = medicRepository.save(medicEntityToSave);

        return updatedmedic;
    }

    public List<MedicEntity> list(Long page, Long count) throws InvalidPageRequestException {
        List<MedicEntity> medicEntityArrayList = medicRepository.findAll(PageRequest.of(page.intValue(), count.intValue())).toList();

        return medicEntityArrayList;
    }

    public MedicEntity findById(Long id) throws InvalidInformationException {
        MedicEntity medicEntity = medicRepository.getOne(id);

        if (medicEntity == null) {
            throw new InvalidInformationException(this.messagesBundle.getMessage(MESSAGE_INVALID_MEDIC_INFORMATION_ID));
        }

        return medicEntity;
    }

    public MedicEntity delete(Long id) throws InvalidInformationException {
        MedicEntity medicEntity = this.findById(id);

        if (medicEntity == null) {
            throw new InvalidInformationException(this.messagesBundle.getMessage(MESSAGE_INVALID_MEDIC_INFORMATION_ID));
        }

        medicRepository.delete(medicEntity);

        return medicEntity;
    }

    public Long count() {

        Long count = medicRepository.count();

        return count;
    }
}


